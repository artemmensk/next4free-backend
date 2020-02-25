package com.artemmensk.next4free.application.collectingprocess;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.artemmensk.next4free.TestCollectingProcessConfig;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcess;

class CollectingProcessServiceTest {

    private final CollectingProcessService collectingProcessService = TestCollectingProcessConfig
            .instance().getCollectingProcessConfig().collectingProcessService();

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