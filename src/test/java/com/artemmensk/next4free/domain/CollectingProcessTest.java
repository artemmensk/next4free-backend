package com.artemmensk.next4free.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.doThrow;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CollectingProcessTest {
    private static final LocalDateTime CREATED_ON = LocalDateTime.of(2019, 11, 1, 12, 30);
    private static final LocalDateTime COMPLETED_ON = LocalDateTime.of(2019, 12, 1, 12, 30);

    private static final CollectingProcessId COLLECTING_PROCESS_ID = CollectingProcessId
            .from(UUID.randomUUID().toString());
    private static final ClientId CLIENT_ID = ClientId.from(UUID.randomUUID().toString());
    private static final BusinessId BUSINESS_ID = BusinessId.from(UUID.randomUUID().toString());

    @Mock
    private CollectingProcessPolicy collectingProcessPolicy;

    @Test
    void should_complete_process() {
        // Given
        final CollectingProcess collectingProcess = CollectingProcess
                .create(COLLECTING_PROCESS_ID, CLIENT_ID, BUSINESS_ID, collectingProcessPolicy, CREATED_ON);
        collectingProcess.stamp(stampFixture());

        // When
        collectingProcess.complete(COMPLETED_ON);

        // Then
        assertThat(collectingProcess.getCompleted()).isEqualTo(COMPLETED_ON);
    }

    @Test
    void should_not_complete_process_when_policy_violated() {
        // Given
        final CollectingProcess collectingProcess = CollectingProcess
                .create(COLLECTING_PROCESS_ID, CLIENT_ID, BUSINESS_ID, collectingProcessPolicy, CREATED_ON);
        doThrow(new RuntimeException("not enough stamps")).when(collectingProcessPolicy)
                .assertSatisfied(collectingProcess);
        collectingProcess.stamp(stampFixture());

        // When
        final Throwable throwable = catchThrowable(() -> collectingProcess.complete(COMPLETED_ON));

        // Then
        assertThat(collectingProcess.getCompleted()).isNull();
        assertThat(throwable).hasMessage("not enough stamps");
    }

    private Stamp stampFixture() {
        final StampId stampId = new StampId(UUID.randomUUID().toString());
        final LocalDateTime createdOn = LocalDateTime.now();

        return Stamp.create(stampId, createdOn);
    }
}