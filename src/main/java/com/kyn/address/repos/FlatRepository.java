package com.kyn.address.repos;

import java.util.UUID;

import com.kyn.address.domain.Flat;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FlatRepository extends MongoRepository<Flat, UUID> {
}
