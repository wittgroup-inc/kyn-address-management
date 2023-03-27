package com.gowittgroup.kyn.address.db.repositories;

import com.gowittgroup.kyn.address.db.entities.ApartmentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;


public interface ApartmentRepository extends MongoRepository<ApartmentEntity, UUID> {
}
