package com.wittgroup.kyn.address.db.repositories;

import com.wittgroup.kyn.address.db.entities.AddressEntity;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AddressRepository extends MongoRepository<AddressEntity, UUID> {
}