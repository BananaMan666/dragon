package com.dragon.banana.configure;

import com.dragon.banana.auth.AuthInterceptor;
import com.dragon.banana.auth.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liulongxiang
 * @Date 2023/9/17 16:36
 * @Description TODO
 */
@Configuration
@RequiredArgsConstructor
public class WebMvcAutoConfiguration implements WebMvcConfigurer {
    private final AuthInterceptor authInterceptor;
    private final JwtTokenUtils jwtTokenUtils;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/jwtUser/login")
                .excludePathPatterns("/register")
                ;
    }
}
