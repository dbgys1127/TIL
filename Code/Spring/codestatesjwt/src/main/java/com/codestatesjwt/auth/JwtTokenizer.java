package com.codestatesjwt.auth;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class JwtTokenizer {
    //(1) Plain Text 형태인 Secret Key의 byte[]를 Base64 형식의 문자열로 인코딩 해준다.
    public String encodeBase64SecretKey(String secretKey) {
        return Encoders.BASE64.encode(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    //(2) 인증된 사용자에게 JWT를 최초로 발급해주기 위한 JWT생성 메서드다.
    public String generateAccessToken(Map<String, Object>claims,
                                      String subject,
                                      Date expiration,
                                      String base64EncodedSecretKey){
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        return Jwts.builder()
                .setClaims(claims)//(2-2) 사용자와 관련된 정보를 추가
                .setSubject(subject)//(2-3)
                .setIssuedAt(Calendar.getInstance().getTime())//(2-4) 발행일자 설정
                .setExpiration(expiration)//(2-5) 만료 일자 설정
                .signWith(key)//(2-6) 서명을 위한 객체 설정
                .compact();//(2-7) JWT를 생성하고 직렬화 한다.
    }

    //(3) Access Token을 새로 생성할수 있게 Refresh Token을 생성하는 메서드
    public String generateRefreshToken(String subject, Date expiration, String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        return  Jwts.builder()
                .setSubject(subject)//(2-3)
                .setIssuedAt(Calendar.getInstance().getTime())//(2-4)
                .setExpiration(expiration)//(2-5)
                .signWith(key)//(2-6)
                .compact();//(2-7)
    }

    //(4) JWT 검증을 위한 메서드
    // JWT에 포함된 Signature를 검증하여 위변조를 파악한다.
    private Key getKeyFromBase64EncodedKey(String base64EncodedSecretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(base64EncodedSecretKey); //(4-1)
        Key key = Keys.hmacShaKeyFor(keyBytes); // key Byte array에 HMAC알고리즘을 적용한 Key객체를 생성한다.
        return key;
    }

    public void verifySignature(String jws, String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jws);
    }
}
