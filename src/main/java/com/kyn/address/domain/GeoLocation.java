package com.kyn.address.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;


@Getter
@Setter
public class GeoLocation {

    @NotNull
    private Long latitude;

    @NotNull
    private Long longitude;

    public static final GeoLocation EMPTY = new GeoLocation();
}
