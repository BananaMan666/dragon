package com.dragon.banana.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.banana.auth.JwtTokenUtils;
import com.dragon.banana.auth.JwtUser;
import com.dragon.banana.base.convert.CommonConvert;
import com.dragon.banana.base.exception.BizException;
import com.dragon.banana.base.response.ResultCode;
import com.dragon.banana.controller.dto.RegisterDto;
import com.dragon.banana.entity.AuthUser;
import com.dragon.banana.mapper.AuthUserMapper;
import com.dragon.banana.service.AuthUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author llx
 * @since 2023-09-17
 */
@Service
@AllArgsConstructor
@Slf4j
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {

//    todo 验证
    private final JwtTokenUtils jwtTokenUtils;
    private final CommonConvert commonConvert;

    @Override
    public String getToken(JwtUser jwtUser) {
        //验证user是否存在
        Optional<AuthUser> userOp = Optional.ofNullable(getOne(Wrappers.<AuthUser>lambdaQuery().eq(AuthUser::getLdap, jwtUser.getLdap())));
        if (!userOp.isPresent()) {
            throw new BizException(ResultCode.USER_NOT_EXIST.message());
        }
        //验证jwtUser是否合法
        AuthUser user = userOp.get();
        if (!jwtUser.getPassword().equals(user.getPassword())){
            throw new BizException(ResultCode.USER_LOGIN_ERROR.message());
        }

        //生成token并返回
        String token = jwtTokenUtils.createToken(jwtUser);
        return token;
    }

    @Override
    public boolean register(RegisterDto dto) {
        //ldap为潍柴内部账号（保证唯一性）
        int ldapNum = count(Wrappers.<AuthUser>lambdaQuery().eq(AuthUser::getLdap, dto.getLdap()));
        if (ldapNum > 0){
            throw new BizException("ldap输入不正确");
        }
        AuthUser authUser = commonConvert.registerDtoToAuthUser(dto);
        boolean flag = save(authUser);

        return flag;
    }
}
