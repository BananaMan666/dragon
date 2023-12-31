package com.dragon.banana.auth;

import com.dragon.banana.base.exception.BizException;
import com.dragon.banana.base.response.ResultCode;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private Gson gson;

    public static final String JWTAUTH_PREFIX = "Bearer ";
    private static final String ISS = "dragon-banana";
    private static final String JWT_SECRET = "BEMhFEvAXJuQ9XrAQ3tOyfwJkOpN3yq5";
    private static final Long TTL = 12 * 60 * 60 * 1000L;

    public String createToken(JwtUser jwtuser) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                // 颁发者，可设置成自己项目的名字
                .setIssuer(ISS)
                //所有者
                .setSubject(new Gson().toJson(jwtuser))
                .setIssuedAt(new Date())
//               .setExpiration(new Date(System.currentTimeMillis() + TTL))
                .compact();
    }

    public JwtUser getJwtUser(String token) {
        return gson.fromJson(getTokenClaims(token).getSubject(), JwtUser.class);
    }

    public Claims getTokenClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            throw new BizException(ResultCode.PERMISSION_NO_ACCESS.message());
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
