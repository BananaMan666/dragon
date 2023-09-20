package com.dragon.banana.controller;


import com.dragon.banana.auth.JwtTokenUtils;
import com.dragon.banana.auth.JwtUser;
import com.dragon.banana.base.response.BizResponse;
import com.dragon.banana.service.AuthUserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author llx
 * @since 2023-09-17
 */
@RestController
@RequestMapping("/jwtUser")
@AllArgsConstructor
public class JwtUserController {
    private final AuthUserService userService;
    private final JwtTokenUtils jwtTokenUtils;

    @ApiOperation("账号登录")
    @PostMapping("login")
    public BizResponse<String> login(JwtUser jwtUser){
        /*Assert.notNull(jwtUser.getLdap(), "请输入账号");
        Assert.notNull(jwtUser.getPassword(), "请输入密码");*/
        return BizResponse.ok(userService.getToken(jwtUser));
    }

}
