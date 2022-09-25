package com.kyn.address.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;


@Document
@Getter
@Setter
public class GeoLocation {

    @Id
    private UUID id;

    @NotNull
    private Long latitude;

    @NotNull
    private Long longitude;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

    public static final GeoLocation EMPTY = new GeoLocation();
}
