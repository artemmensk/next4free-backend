package com.artemmensk.next4free.infra.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.artemmensk.next4free.domain.CollectingProcess;
import com.artemmensk.next4free.domain.CollectingProcessId;
import com.artemmensk.next4free.domain.CollectingProcessRepository;

public interface MongoCollectingProcessRepository extends CollectingProcessRepository,
        MongoRepository<CollectingProcess, CollectingProcessId> {
}
