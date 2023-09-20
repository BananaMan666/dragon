package com.dragon.banana.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liulongxiang
 * @Date 2023/9/20 15:51
 * @Description 注册dto
 */
@Data
public class RegisterDto {
    @NotBlank(message = "ldap不能为空")
    private String ldap;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
