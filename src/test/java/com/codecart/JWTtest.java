package com.codecart;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTtest {
    @Test
    public void test() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("username","haiyang");
      String token = JWT.create()
                .withClaim("user",map)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*24))
                .sign(Algorithm.HMAC256("haiyang"));
        System.out.println(token);
    }
    @Test
    public void testParseToken() throws Exception{
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDY0NTEzMTcsInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoiaGFpeWFuZyJ9fQ.txWK8Qi9X1zRu1yU68Q6UsKpq6yULm2Qd0y01WmJXYc";
        JWTVerifier verifier =   JWT.require(Algorithm.HMAC256("haiyang")).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
