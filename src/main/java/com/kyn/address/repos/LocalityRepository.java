package com.kyn.address.repos;

import java.util.UUID;

import com.kyn.address.domain.Locality;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LocalityRepository extends MongoRepository<Locality, UUID> {
}
