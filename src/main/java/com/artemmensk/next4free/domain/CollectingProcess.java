package com.artemmensk.next4free.domain;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectingProcess {

    @Id
    private CollectingProcessId collectingProcessId;
    private ClientId clientId;
    private BusinessId businessId;
    private CollectingProcessPolicy collectingProcessPolicy;
    private Set<Stamp> stamps;
    private LocalDateTime created;
    private LocalDateTime completed;

    public static CollectingProcess create(
            CollectingProcessId collectingProcessId,
            ClientId clientId,
            BusinessId businessId,
            CollectingProcessPolicy collectingProcessPolicy,
            LocalDateTime createdOn) {
        final CollectingProcess collectingProcess = new CollectingProcess();
        collectingProcess.collectingProcessId = collectingProcessId;
        collectingProcess.clientId = clientId;
        collectingProcess.businessId = businessId;
        collectingProcess.collectingProcessPolicy = collectingProcessPolicy;
        collectingProcess.created = createdOn;
        collectingProcess.stamps = new HashSet<>();
        return collectingProcess;
    }

    public void stamp(Stamp stamp) {
        stamps.add(stamp);
    }

    public void complete(LocalDateTime completed) {
        assertProcessPolicy();

        this.completed = completed;
    }

    private void assertProcessPolicy() {
        collectingProcessPolicy.assertSatisfied(this);
    }

}
