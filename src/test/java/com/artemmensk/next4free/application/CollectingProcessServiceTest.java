package com.artemmensk.next4free.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.artemmensk.next4free.TestApplicationConfig;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.CollectingProcess;

class CollectingProcessServiceTest {

    private final CollectingProcessService collectingProcessService = TestApplicationConfig
            .instance().getApplicationConfig().processService();

    @Test
    void should_create_process_and_stamp_and_return_process() {
        // Given
        final ClientId clientId = ClientId.from(UUID.randomUUID().toString());
        final BusinessId businessId = BusinessId.from(UUID.randomUUID().toString());

        // When
        collectingProcessService.stamp(businessId, clientId);
        final CollectingProcess collectingProcess = collectingProcessService.getCurrentProcess(businessId, clientId);

        // Then
        assertThat(collectingProcess);
    }

}