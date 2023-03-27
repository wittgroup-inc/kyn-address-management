package com.gowittgroup.kyn.address.db.repositories;

import com.gowittgroup.kyn.address.db.entities.LocalityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;


public interface LocalityRepository extends MongoRepository<LocalityEntity, UUID> {
}
