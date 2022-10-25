package com.wittgroup.kyn.address.db.entities;

import com.wittgroup.kyn.address.models.GeoLocation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.UUID;


@Document("apartment")
@Getter
@Setter
public class ApartmentEntity {

    @Id
    private UUID id;

    @Size(max = 255)
    private String holdingNumber;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String displayPicUrl;

    private GeoLocation geoLocation;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

}
