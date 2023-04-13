package com.gowittgroup.kyn.address.db.repositories;

import com.gowittgroup.kyn.address.db.entities.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;


public interface AddressRepository extends MongoRepository<AddressEntity, UUID> {
}
