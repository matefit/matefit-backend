package io.matefit.api.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.matefit.core.domain.Account;
import io.matefit.core.dto.security.JwtToken;
import io.matefit.core.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@PropertySource("classpath:jwt.properties")
@RequiredArgsConstructor
public class JwtServiceImpl {

    @Value("${issuer}")
    private String issuer;

    @Value("${secret}")
    private String secret;

    private final AccountRepository accountRepository;

    public JwtToken createToken(Account account) throws JWTCreationException {
        String token = JWT.create()
                .withIssuer(issuer)
                .withClaim("id", account.getId())
                .sign(Algorithm.HMAC256(secret));

        return new JwtToken(token);
    }

    public Long validateToken(String token) {
        try {
            final JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
            final DecodedJWT decodedJWT = jwtVerifier.verify(token);
            final Long accountId = decodedJWT.getClaim("id").asLong();

            return accountId;
        } catch (SignatureVerificationException | JWTDecodeException e) {
            return null;
        }
    }
}
