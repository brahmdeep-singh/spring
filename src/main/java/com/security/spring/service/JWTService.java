package com.security.spring.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.Base64.Decoder;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service 
public class JWTService {

    private String secretKey="";

    public JWTService(){
        try {
            KeyGenerator keyGen= KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk=keyGen.generateKey();
            secretKey=Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String generateToken(String username){
        return Jwts
        .builder()
        .claims()
        .subject(username)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis()+1000*60*30))
        .and()
        .signWith(getKey())
        .compact();
    }
    private Key getKey(){
        byte[] key =Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(key);
    }
}
