package com.artemmensk.next4free.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internalId;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(nullable = false, unique = true, name = "externalId"))
    private ClientId externalId;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(nullable = false, name = "clientName"))
    private ClientName clientName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Account account;

    public static Client from(
            Account account,
            ClientId clientId,
            ClientName clientName) {
        final Client client = new Client();
        client.setAccount(account);
        client.setExternalId(clientId);
        client.setClientName(clientName);
        return client;
    }

    @Override
    public String toString() {
        return "Client{" +
                "externalId=" + externalId +
                ", clientName=" + clientName +
                '}';
    }
}
