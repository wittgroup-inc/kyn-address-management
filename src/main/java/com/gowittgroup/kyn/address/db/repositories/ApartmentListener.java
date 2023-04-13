package com.gowittgroup.kyn.address.db.repositories;

import com.gowittgroup.kyn.address.db.entities.ApartmentEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class ApartmentListener extends AbstractMongoEventListener<ApartmentEntity> {

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<ApartmentEntity> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(UUID.randomUUID());
        }
    }

}
