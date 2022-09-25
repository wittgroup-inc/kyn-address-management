package com.kyn.address.repos;

import com.kyn.address.domain.Address;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AddressRepository extends MongoRepository<Address, UUID> {
}
