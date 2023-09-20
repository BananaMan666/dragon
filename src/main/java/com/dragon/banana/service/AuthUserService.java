package com.dragon.banana.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dragon.banana.auth.JwtUser;
import com.dragon.banana.base.response.ResultCode;
import com.dragon.banana.controller.dto.RegisterDto;
import com.dragon.banana.entity.AuthUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author llx
 * @since 2023-09-17
 */
public interface AuthUserService extends IService<AuthUser> {

    /**
     * 验证登录信息并返回token
     *
     * @param jwtUser
     * @return
     */
    String getToken(JwtUser jwtUser);

    /**
     * 用户注册
     *
     * @param dto
     * @return
     */
    boolean register(RegisterDto dto);
}
