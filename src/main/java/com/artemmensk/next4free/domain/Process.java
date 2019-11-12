package com.artemmensk.next4free.domain;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Process {

    @Id
    private ProcessId processId;
    private ClientId clientId;
    private BusinessId businessId;
    private ProcessPolicy processPolicy;
    private Set<Stamp> stamps;
    private LocalDateTime created;
    private LocalDateTime completed;

    public static Process create(
            ProcessId processId,
            ClientId clientId,
            BusinessId businessId,
            ProcessPolicy processPolicy,
            LocalDateTime createdOn) {
        final Process process = new Process();
        process.processId = processId;
        process.clientId = clientId;
        process.businessId = businessId;
        process.processPolicy = processPolicy;
        process.created = createdOn;
        process.stamps = new HashSet<>();
        return process;
    }

    public void stamp(Stamp stamp) {
        stamps.add(stamp);
    }

    public void complete(LocalDateTime completed) {
        assertProcessPolicy();

        this.completed = completed;
    }

    private void assertProcessPolicy() {
        processPolicy.assertSatisfied(this);
    }

}
