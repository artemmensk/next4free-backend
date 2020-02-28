package com.artemmensk.next4free.infra.token;

import java.util.Optional;

import com.artemmensk.next4free.application.authentication.Token;
import com.artemmensk.next4free.application.authentication.TokenService;
import com.artemmensk.next4free.domain.Account;
import com.artemmensk.next4free.domain.Business;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.Client;
import com.artemmensk.next4free.domain.ClientId;

public class JwtTokenService implements TokenService {
    @Override
    public Token generateToken(Account account) {

        final BusinessId businessId = Optional.ofNullable(account.getBusiness())
                .map(Business::getExternalId)
                .orElse(null);

        final ClientId clientId = Optional.ofNullable(account.getClient())
                .map(Client::getExternalId)
                .orElse(null);

        return () -> "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJzdWIiOiIxMjM0NTY3ODkwIiwiY2xpZW50SWQiOiJoYXJkY29kZWQgY2xpZW50IGlkIiwiaWF0IjoxNTE2MjM5MDIyfQ" +
                ".lk2I759vYbzcDYcSpblmOu4jgOgNErrdDwALHyF3ddQ";
    }
}
