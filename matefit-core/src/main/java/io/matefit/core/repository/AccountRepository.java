package io.matefit.core.repository;

import io.matefit.core.domain.Account;
import io.matefit.core.domain.ProviderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByProviderTypeAndProviderId(ProviderType providerType, String providerId);
}
