package com.gowittgroup.kyn.address.db.repositories;

import com.gowittgroup.kyn.address.db.entities.LocalityEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class LocalityListener extends AbstractMongoEventListener<LocalityEntity> {

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<LocalityEntity> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(UUID.randomUUID());
        }
    }

}
