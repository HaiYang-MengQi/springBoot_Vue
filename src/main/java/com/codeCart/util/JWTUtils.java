package com.codeCart.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static String KEY = "dream";
    public static String generateToken(Integer id,String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username", username);
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
