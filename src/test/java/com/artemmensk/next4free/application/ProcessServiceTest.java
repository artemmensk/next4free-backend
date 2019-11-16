package com.artemmensk.next4free.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.artemmensk.next4free.TestApplicationConfig;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.Process;

class ProcessServiceTest {

    private final ProcessService processService = TestApplicationConfig
            .instance().getApplicationConfig().processService();

    @Test
    void should_create_process_and_stamp_and_return_process() {
        // Given
        final ClientId clientId = ClientId.from(UUID.randomUUID().toString());
        final BusinessId businessId = BusinessId.from(UUID.randomUUID().toString());

        // When
        processService.stamp(businessId, clientId);
        final Process process = processService.getCurrentProcess(businessId, clientId);

        // Then
        assertThat(process);
    }

}