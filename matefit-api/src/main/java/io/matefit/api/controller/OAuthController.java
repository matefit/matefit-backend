package io.matefit.api.controller;

import io.matefit.api.service.AccountService;
import io.matefit.core.domain.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OAuthController {

    private final AccountService accountService;

    /*
    카카오 회원가입 또는 로그인
     */
    @GetMapping("/oauth/kakao")
    public Account kakaoLogin(@RequestParam(required = false) String code) {
        return accountService.getAccountByProvider(code);
    }
}
