package com.kyn.address.repos;

import java.util.UUID;

import com.kyn.address.domain.Apartment;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ApartmentRepository extends MongoRepository<Apartment, UUID> {
}
