package com.dragon.banana.controller.ctrl;


import com.dragon.banana.auth.JwtTokenUtils;
import com.dragon.banana.auth.JwtUser;
import com.dragon.banana.base.response.BizResponse;
import com.dragon.banana.controller.dto.RegisterDto;
import com.dragon.banana.entity.AuthUser;
import com.dragon.banana.service.AuthUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
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
@Api(tags = "登录相关")
@RequestMapping("/jwtUser")
@AllArgsConstructor
public class JwtUserController {
    private final AuthUserService userService;

    @ApiOperation("账号登录")
    @PostMapping("login")
    public BizResponse<String> login(JwtUser jwtUser){
        /*Assert.notNull(jwtUser.getLdap(), "请输入账号");
        Assert.notNull(jwtUser.getPassword(), "请输入密码");*/
        return BizResponse.ok(userService.getToken(jwtUser));
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public BizResponse<?> register(@Validated RegisterDto dto){
        return BizResponse.ok(userService.register(dto));
    }

}
