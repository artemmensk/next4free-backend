package com.artemmensk.next4free.infra.token;

import com.artemmensk.next4free.application.authentication.Token;
import com.artemmensk.next4free.application.authentication.TokenService;
import com.artemmensk.next4free.domain.Account;

public class JwtTokenService implements TokenService {
    @Override
    public Token generateToken(Account account) {
        return () -> "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwiY2xpZW50SWQiOiJoYXJkY29kZWQgY2xpZW50IGlkIiwiaWF0IjoxNTE2MjM5MDIyfQ.lk2I759vYbzcDYcSpblmOu4jgOgNErrdDwALHyF3ddQ";
    }
}
