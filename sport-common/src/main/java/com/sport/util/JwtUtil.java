package com.sport.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    /**
     * 生成jwt令牌
     * 签名算法使用HS384
     *
     * @param secretKey
     * @param ttlMillis
     * @param claims
     * @return jwt令牌
     */
    public static String creatJwt(String secretKey, long ttlMillis, Map<String ,Object> claims){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date date = new Date(expMillis);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setExpiration(date)
                .signWith(signatureAlgorithm,secretKey.getBytes(StandardCharsets.UTF_8));
        return builder.compact();
    }

    /**
     * 解析jwt,获得payload信息
     *
     * @param token
     * @param secretKey
     * @return
     */
    public static Claims parseJwt(String token,String secretKey){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
                //取出Claim
                .parseClaimsJws(token).getBody();
        return claims;
    }
}
