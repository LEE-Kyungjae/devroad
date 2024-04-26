package com.dev.road;

import com.dev.road.dto.TokenResponse;
import com.dev.road.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@Slf4j
public class TokenProvider {

    private static final long ACCESS_TOKEN_VALID_PREIOD=1000L *60*60*24*8;//8일간 유효
    private final Key jwtSecretKey;

    public TokenProvider(@Value("${jwt.secret-key}") String secretKey){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        jwtSecretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenResponse generateJWT(final User userinfo){
        final Date now = new Date();
        final Date accessTokenExpireln = new Date(now.getTime() + ACCESS_TOKEN_VALID_PREIOD);
        final String accessToken = Jwts.builder()
                .setSubject("authorization")
                .claim("userUuid", userinfo.getUserUuid())
                .claim("role", userinfo.getRole())
                .setExpiration(accessTokenExpireln)
                .signWith(jwtSecretKey, SignatureAlgorithm.HS256)
                .compact();
        return TokenResponse.of(accessToken,accessTokenExpireln.getTime());
    }

}
