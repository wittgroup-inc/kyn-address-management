package com.kyn.address.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.UUID;


@Document
@Getter
@Setter
public class Address {

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

    public static final Address EMPTY = new Address();
}
