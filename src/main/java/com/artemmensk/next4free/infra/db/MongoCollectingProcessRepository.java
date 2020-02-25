package com.artemmensk.next4free.infra.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.artemmensk.next4free.domain.collectingprocess.CollectingProcess;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessId;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessRepository;

public interface MongoCollectingProcessRepository extends CollectingProcessRepository,
        MongoRepository<CollectingProcess, CollectingProcessId> {
}
