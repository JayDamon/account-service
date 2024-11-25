package com.factotum.accountservice.repository;

import com.factotum.accountservice.model.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ItemRepository extends ReactiveCrudRepository<Item, String> {

    Mono<Item> queryByIdAndTenantId(String id, String tenantId);

}
