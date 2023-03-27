package com.gowittgroup.kyn.address.db.entities;

import com.gowittgroup.kyn.address.models.GeoLocation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

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
