package com.kyn.address.repos;

import java.util.UUID;

import com.kyn.address.domain.GeoLocation;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface GeoLocationRepository extends MongoRepository<GeoLocation, UUID> {
}
