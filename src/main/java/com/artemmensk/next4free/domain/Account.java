package com.artemmensk.next4free.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.artemmensk.next4free.application.authentication.PasswordVerifier;

import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue
    private Long databaseId;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(unique = true, name = "accountId"))
    private AccountId accountId;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(unique = true, name = "email"))
    private Email email;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(name = "hashedPassword"))
    private HashedPassword hashedPassword;

    public static Account from(
            Email email,
            HashedPassword hashedPassword,
            AccountId accountId) {
        final Account account = new Account();
        account.setAccountId(accountId);
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
