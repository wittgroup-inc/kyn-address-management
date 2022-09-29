package com.wittgroup.kyn.address.db.repositories;

import java.util.UUID;

import com.wittgroup.kyn.address.db.entities.ApartmentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ApartmentRepository extends MongoRepository<ApartmentEntity, UUID> {
}