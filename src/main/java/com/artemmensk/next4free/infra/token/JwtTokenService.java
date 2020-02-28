package com.artemmensk.next4free.infra.token;

import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

import com.artemmensk.next4free.application.authentication.Token;
import com.artemmensk.next4free.application.authentication.TokenService;
import com.artemmensk.next4free.domain.Account;
import com.artemmensk.next4free.domain.Business;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.Client;
import com.artemmensk.next4free.domain.ClientId;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtTokenService implements TokenService {

    private final Supplier<Date> dateSupplier;

    private static final String JWT_SECRET = "top&secret%secret";
    private static final String ISSUER = "next4free.sauchu.uk";
    private static final String CLIENT_ID_CLAIM_NAME = "clientId";
    private static final String BUSINESS_ID_CLAIM_NAME = "businessId";

    private final Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

    @Override
    public Token generateToken(Account account) {

        final JWTCreator.Builder builder = JWT.create();

        setClientIdClaimIfPresent(account, builder);
        setBusinessIdClaimIfPresent(account, builder);

        return () -> builder
                .withIssuedAt(dateSupplier.get())
                .withIssuer(ISSUER)
                .sign(algorithm);
    }

    private void setClientIdClaimIfPresent(
            Account account,
            JWTCreator.Builder builder) {
        Optional.ofNullable(account.getClient())
                .map(Client::getExternalId)
                .ifPresent(clientId -> setClientIdClaim(builder, clientId));
    }

    private void setBusinessIdClaimIfPresent(
            Account account,
            JWTCreator.Builder builder) {
        Optional.ofNullable(account.getBusiness())
                .map(Business::getExternalId)
                .ifPresent(businessId -> setBusinessIdClaim(builder, businessId));
    }

    private void setClientIdClaim(
            JWTCreator.Builder builder,
            ClientId clientId) {
        builder.withClaim(CLIENT_ID_CLAIM_NAME, clientId.getValue());
    }

    private void setBusinessIdClaim(
            JWTCreator.Builder builder,
            BusinessId businessId) {
        builder.withClaim(BUSINESS_ID_CLAIM_NAME, businessId.getValue());
    }
}
