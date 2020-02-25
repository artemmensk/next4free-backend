package com.artemmensk.next4free;

import java.time.LocalDateTime;
import java.util.UUID;

import com.artemmensk.next4free.application.collectingprocess.CollectingProcessConfig;
import com.artemmensk.next4free.domain.StampId;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessId;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestCollectingProcessConfig {

    private final CollectingProcessConfig collectingProcessConfig;

    public static TestCollectingProcessConfig instance() {

        final CollectingProcessConfig collectingProcessConfig = new CollectingProcessConfig(
                TestCollectingProcessRepository.INSTANCE,
                () -> CollectingProcessId.from(UUID.randomUUID().toString()),
                LocalDateTime::now,
                () -> StampId.from(UUID.randomUUID().toString()));

        return new TestCollectingProcessConfig(collectingProcessConfig);
    }
}
