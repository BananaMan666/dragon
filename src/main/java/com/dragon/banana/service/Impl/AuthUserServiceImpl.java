package com.dragon.banana.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.banana.auth.JwtTokenUtils;
import com.dragon.banana.auth.JwtUser;
import com.dragon.banana.base.exception.BizException;
import com.dragon.banana.base.response.ResultCode;
import com.dragon.banana.entity.AuthUser;
import com.dragon.banana.mapper.AuthUserMapper;
import com.dragon.banana.service.AuthUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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

    private final JwtTokenUtils jwtTokenUtils;

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
        //判断jwtUser登录信息
//        String token = jwtTokenUtils.create

        return null;
    }
}
