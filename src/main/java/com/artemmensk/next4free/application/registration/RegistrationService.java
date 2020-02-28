package com.artemmensk.next4free.application.registration;

import java.util.function.Supplier;

import com.artemmensk.next4free.application.hashing.HashingService;
import com.artemmensk.next4free.domain.Account;
import com.artemmensk.next4free.domain.AccountId;
import com.artemmensk.next4free.domain.AccountRepository;
import com.artemmensk.next4free.domain.Business;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.BusinessName;
import com.artemmensk.next4free.domain.BusinessRepository;
import com.artemmensk.next4free.domain.Client;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.ClientName;
import com.artemmensk.next4free.domain.ClientRepository;
import com.artemmensk.next4free.domain.Email;
import com.artemmensk.next4free.domain.HashedPassword;
import com.artemmensk.next4free.domain.Password;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationService {

    private final AccountRepository accountRepository;
    private final BusinessRepository businessRepository;
    private final ClientRepository clientRepository;
    private final HashingService hashingService;
    private final Supplier<AccountId> accountIdSupplier;
    private final Supplier<BusinessId> businessIdSupplier;
    private final Supplier<ClientId> clientIdSupplier;

    public void registerClient(
            Email email,
            Password password,
            ClientName clientName) {

        final Account account = createAccount(email, password);
        final Client client = Client.from(account, clientIdSupplier.get(), clientName);
        clientRepository.save(client);
    }

    public void registerBusiness(
            Email email,
            Password password,
            BusinessName businessName) {

        final Account account = createAccount(email, password);
        final Business business = Business.from(account, businessIdSupplier.get(), businessName);
        businessRepository.save(business);
    }

    private Account createAccount(
            Email email,
            Password password) {
        assertEmailIsUnoccupied(email);
        final HashedPassword hashedPassword = hashingService.hash(password);
        return Account.from(email, hashedPassword, accountIdSupplier.get());
    }

    private void assertEmailIsUnoccupied(Email email) {
        accountRepository.findByEmail(email).ifPresent(this::throwEmailIsOccupied);
    }

    private void throwEmailIsOccupied(Account account) {
        throw new RuntimeException(String.format("%s already occupied.", account.getEmail()));
    }

}
