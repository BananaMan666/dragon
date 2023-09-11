package com.dragon.banana.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author liulongxiang
 * @Date 2023/9/8 16:47
 * @Description 登录账号Dto
 */
@Data
public class LoginDto implements Serializable {
    @NotBlank(message = "登录用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
