package com.dragon.banana.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.banana.auth.JwtTokenUtils;
import com.dragon.banana.auth.JwtUser;
import com.dragon.banana.entity.AuthUser;
import com.dragon.banana.mapper.AuthUserMapper;
import com.dragon.banana.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author llx
 * @since 2023-09-17
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {

    private final JwtTokenUtils jwtTokenUtils;

//    Wrappers.<UserRole>lambdaQuery().eq(UserRole::getLdap, jwtUser.get
    @Override
    public String getToken(JwtUser jwtUser) {
        //判断jwtUser登录信息
        AuthUser authUser = new AuthUser();
        authUser.setUsername("aaa").setLdap(jwtUser.getLdap()).setPassword(jwtUser.getPassword());
        save(authUser);
        return String.valueOf(authUser.getId());
    }
}
