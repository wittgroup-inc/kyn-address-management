package com.kyn.address.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.UUID;


@Getter
@Setter
public class Flat {

    @Size(max = 255)
    private String flatNumber;

    @Size(max = 255)
    private String tower;

    @Size(max = 255)
    private String floor;

    public static final Flat EMPTY = new Flat();

}
