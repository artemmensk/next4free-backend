package com.artemmensk.next4free.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.artemmensk.next4free.application.authentication.PasswordVerifier;

import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internalId;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(nullable = false, unique = true, name = "externalId"))
    private AccountId externalId;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(nullable = false, unique = true, name = "email"))
    private Email email;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(nullable = false, name = "hashedPassword"))
    private HashedPassword hashedPassword;

    @OneToOne(mappedBy = "account")
    private Business business;

    @OneToOne(mappedBy = "account")
    private Client client;

    public static Account from(
            Email email,
            HashedPassword hashedPassword,
            AccountId accountId) {
        final Account account = new Account();
        account.setExternalId(accountId);
        account.setEmail(email);
        account.setHashedPassword(hashedPassword);
        return account;
    }

    public void assertPasswordIsCorrect(
            PasswordVerifier passwordVerifier,
            Password passedPassword) {
        passwordVerifier.assertPasswordIsCorrect(passedPassword, hashedPassword);
    }
}
