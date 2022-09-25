package com.kyn.address.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;


@Document
@Getter
@Setter
public class Address {

    @Id
    private UUID id;

    @DocumentReference(lazy = true)
    private Locality locality;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

    public static final Address EMPTY = new Address();
}
