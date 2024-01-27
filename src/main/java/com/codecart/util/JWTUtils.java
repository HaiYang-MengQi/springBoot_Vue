package com.codecart.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class JWTUtils {
    private static String KEY = "dream";
    public static String generateToken(Map<String, Object> map) {
       return JWT.create()
                .withClaim("claims",map)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*24))
                .sign(Algorithm.HMAC256(KEY));
    }
    public static Map<String, Object> parseToken(String token)  {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
