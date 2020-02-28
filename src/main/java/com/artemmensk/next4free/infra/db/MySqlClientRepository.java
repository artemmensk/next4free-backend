package com.artemmensk.next4free.infra.db;

import org.springframework.data.repository.CrudRepository;

import com.artemmensk.next4free.domain.Client;
import com.artemmensk.next4free.domain.ClientRepository;


public interface MySqlClientRepository extends ClientRepository, CrudRepository<Client, Long> {
}
