package com.artemmensk.next4free.application.registration;

import java.util.function.Supplier;

import com.artemmensk.next4free.application.hashing.HashingService;
import com.artemmensk.next4free.domain.Account;
import com.artemmensk.next4free.domain.AccountId;
import com.artemmensk.next4free.domain.AccountRepository;
import com.artemmensk.next4free.domain.Email;
import com.artemmensk.next4free.domain.HashedPassword;
import com.artemmensk.next4free.domain.Password;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationService {

    private final AccountRepository accountRepository;
    private final HashingService hashingService;
    private final Supplier<AccountId> accountIdSupplier;

    public void register(
            Email email,
            Password password) {

        assertEmailIsUnoccupied(email);

        final HashedPassword hashedPassword = hashingService.hash(password);

        final Account account = Account.from(email, hashedPassword, accountIdSupplier.get());
        accountRepository.save(account);
    }

    private void assertEmailIsUnoccupied(Email email) {
        accountRepository.findByEmail(email).ifPresent(this::throwEmailIsOccupied);
    }

    private void throwEmailIsOccupied(Account account) {
        throw new RuntimeException(String.format("%s already occupied.", account.getEmail()));
    }

}
