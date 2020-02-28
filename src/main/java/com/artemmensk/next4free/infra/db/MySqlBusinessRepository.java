package com.artemmensk.next4free.infra.db;

import org.springframework.data.repository.CrudRepository;

import com.artemmensk.next4free.domain.Business;
import com.artemmensk.next4free.domain.BusinessRepository;


public interface MySqlBusinessRepository extends BusinessRepository, CrudRepository<Business, Long> {
}
