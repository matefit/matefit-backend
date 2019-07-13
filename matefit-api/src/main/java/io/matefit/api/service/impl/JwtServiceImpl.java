package io.matefit.api.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.matefit.core.domain.Account;
import io.matefit.core.dto.security.JwtToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@PropertySource("classpath:jwt.properties")
@RequiredArgsConstructor
public class JwtServiceImpl {

    @Value("${issuer}")
    private String issuer;

    @Value("${secret}")
    private String secret;

    public JwtToken createToken(Account account) throws JWTCreationException {
        String token = JWT.create()
                .withIssuer(issuer)
                .withClaim("id", account.getId())
                .sign(Algorithm.HMAC256(secret));

        return new JwtToken(token);
    }

    public boolean validateToken(String token) throws JWTVerificationException {
        final JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        final DecodedJWT decodedJWT = jwtVerifier.verify(token);
        final Map<String, Claim> claims = decodedJWT.getClaims();
        final Claim id = claims.get("id");

        return false;
    }
}
