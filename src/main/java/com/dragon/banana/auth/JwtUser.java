package com.dragon.banana.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @author liulongxiang
 * @Date 2023/9/12 09:35
 * @Description TODO
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class JwtUser {
    @NotBlank(message = "用户名不能为空")
    private String ldap;
    @NotBlank(message = "密码不能为空")
    private String password;
    private String role;
}
