package com.artemmensk.next4free;

import java.time.LocalDateTime;
import java.util.UUID;

import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessId;
import com.artemmensk.next4free.domain.StampId;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestApplicationConfig {

    private final ApplicationConfig applicationConfig;

    public static TestApplicationConfig instance() {

        final ApplicationConfig applicationConfig = new ApplicationConfig(
                TestCollectingProcessRepository.INSTANCE,
                () -> CollectingProcessId.from(UUID.randomUUID().toString()),
                LocalDateTime::now,
                () -> StampId.from(UUID.randomUUID().toString()));

        return new TestApplicationConfig(applicationConfig);
    }
}
