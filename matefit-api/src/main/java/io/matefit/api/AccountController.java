package io.matefit.api;

import io.matefit.core.domain.Account;
import io.matefit.core.domain.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    final private AccountRepository accountRepository;

    @GetMapping("/")
    public Account account() {
        return accountRepository.save(
                Account.builder()
                    .email("byeonggukgong@gmail.com")
                    .build()
        );
    }
}
