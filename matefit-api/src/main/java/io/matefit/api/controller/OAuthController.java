package io.matefit.api.controller;

import io.matefit.api.service.AccountService;
import io.matefit.api.service.impl.JwtServiceImpl;
import io.matefit.core.dto.security.JwtToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OAuthController {

    private final JwtServiceImpl jwtService;
    private final AccountService accountService;

    /*
    카카오 회원가입 또는 로그인
     */
    @GetMapping("/oauth/kakao")
    public ResponseEntity<JwtToken> kakaoLogin(@RequestBody Map<String, Object> body) {
        return new ResponseEntity<JwtToken>(
                jwtService.createToken(
                        accountService.getAccountByProvider(body.get("access_token").toString())), HttpStatus.OK);
    }
}
