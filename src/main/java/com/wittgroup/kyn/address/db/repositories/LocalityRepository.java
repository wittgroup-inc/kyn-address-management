package com.wittgroup.kyn.address.db.repositories;

import java.util.UUID;

import com.wittgroup.kyn.address.db.entities.LocalityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LocalityRepository extends MongoRepository<LocalityEntity, UUID> {
}
