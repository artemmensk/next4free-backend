package com.artemmensk.next4free.infra.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.artemmensk.next4free.domain.Process;
import com.artemmensk.next4free.domain.ProcessId;
import com.artemmensk.next4free.domain.ProcessRepository;

public interface MongoProcessRepository extends ProcessRepository, MongoRepository<Process, ProcessId> {
}
