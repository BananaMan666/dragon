package com.dragon.banana.auth;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dragon.banana.base.exception.BizException;
import com.dragon.banana.base.response.ResultCode;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liulongxiang
 * @Date 2023/9/17 16:33
 * @Description JWT USER解析 todo
 */
@RequiredArgsConstructor
public class JwtUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

//    private final UserRoleStorage userRoleStorage;
    private final JwtTokenUtils jwtTokenUtils;
//    private final UserStorage userStorage;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(JwtUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String authToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.isEmpty(authToken)) {
            String token = authToken.replace(JwtTokenUtils.JWTAUTH_PREFIX, "");
            /*JwtUser jwtUser = jwtTokenUtils.getJwtUser(token);

            // 更新角色
            UserRole userRole = userRoleStorage.getOne(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getLdap, jwtUser.getUserLdap()), false);
            if (userRole == null) {
                throw new BizException(ResultCode.ACCOUNT_NO_ENOUGH_PERMISSION.message());
            }
            jwtUser.setRole(userRole.getRoleKey());
            //更新姓名
            AuthUser ivyUser = userStorage.getByLdap(jwtUser.getUserLdap())
                    .filter(u -> u.getUserStatus() == 1)
                    .orElseThrow(() -> new BizException("查无此人"));
            jwtUser.setUserName(ivyUser.getUserName());
            return jwtUser;*/
            return null;
        }
        return null;
    }

}
