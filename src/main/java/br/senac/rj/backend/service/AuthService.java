package br.senac.rj.backend.service;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class AuthService {

    // Chave secreta para assinatura (em produção, guarde em lugar seguro)
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String gerarToken(String email) {
        long expMillis = System.currentTimeMillis() + 3600_000; // 1 hora de validade
        Date exp = new Date(expMillis);

        String jwt = Jwts.builder()
                .setSubject(email)           // identifica o usuário
                .setIssuedAt(new Date())     // data de emissão
                .setExpiration(exp)          // data de expiração
                .signWith(KEY)               // assina com a chave secreta
                .compact();

        return jwt;
    }
}

