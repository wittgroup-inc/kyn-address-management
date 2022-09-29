package com.wittgroup.kyn.address.db.entities;

import com.wittgroup.kyn.address.models.Flat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.UUID;


@Document("address")
@Getter
@Setter
public class AddressEntity {

    @Id
    private UUID id;

    private Flat flat;

    private UUID apartment;

    private UUID locality;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

}
