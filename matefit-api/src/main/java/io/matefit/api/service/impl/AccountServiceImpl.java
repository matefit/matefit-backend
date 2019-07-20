package io.matefit.api.service.impl;

import io.matefit.api.service.AccountService;
import io.matefit.api.service.KakaoService;
import io.matefit.core.domain.Account;
import io.matefit.core.domain.ProviderType;
import io.matefit.core.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final KakaoService kakaoService;
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public Account getAccountByProvider(String accessToken) {
        final String providerId = kakaoService.getInfo(accessToken)
                .get("id").asText();

        return accountRepository.findAccountByProviderTypeAndProviderId(
                ProviderType.KAKAO, providerId)
                .orElseGet(() -> {
                    Account account = Account.builder()
                            .providerType(ProviderType.KAKAO)
                            .providerId(providerId)
                            .build();

                    return accountRepository.save(account);
                });
    }
}
