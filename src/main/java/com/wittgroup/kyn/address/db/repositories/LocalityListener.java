package com.wittgroup.kyn.address.db.repositories;

import java.util.UUID;

import com.wittgroup.kyn.address.db.entities.LocalityEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class LocalityListener extends AbstractMongoEventListener<LocalityEntity> {

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<LocalityEntity> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(UUID.randomUUID());
        }
    }

}
