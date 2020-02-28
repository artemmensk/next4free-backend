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
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internalId;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(nullable = false, unique = true, name = "externalId"))
    private BusinessId externalId;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(nullable = false, name = "businessName"))
    private BusinessName businessName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Account account;

    public static Business from(
            Account account,
            BusinessId businessId,
            BusinessName businessName) {
        final Business business = new Business();
        business.setAccount(account);
        business.setExternalId(businessId);
        business.setBusinessName(businessName);
        return business;
    }

    @Override
    public String toString() {
        return "Business{" +
                "externalId=" + externalId +
                ", businessName=" + businessName +
                '}';
    }
}
