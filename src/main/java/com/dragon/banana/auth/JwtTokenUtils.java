package com.dragon.banana.auth;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author liulongxiang
 * @Date 2023/9/12 09:37
 * @Description
 */
@Component
@RequiredArgsConstructor
public class JwtTokenUtils {

    public static final String JWTAUTH_PREFIX = "Bearer ";
    private static final String ISS = "dragon-banana";
    private static final String JWT_SECRET = "BEMhFEvAXJuQ9XrAQ3tOyfwJkOpN3yq5";
    private static final Long TTL = 12 * 60 * 60 * 1000L;

    public static String createToken(JwtUser jwtuser) {
       /* return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .setIssuer(ISS) // 颁发者，可设置成自己项目的名字
                .setSubject(new Gson().toJson(jwtuser)) //所有者
                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + TTL))
                .compact();*/
        return null;
    }
}
