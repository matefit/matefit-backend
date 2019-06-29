package io.matefit.api.service;

import io.matefit.core.domain.Account;

public interface AccountService {

    Account getAccountByProvider(String code);
}
