package com.kyn.address.repos;

import java.util.UUID;

import com.kyn.address.domain.Locality;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class LocalityListener extends AbstractMongoEventListener<Locality> {

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<Locality> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(UUID.randomUUID());
        }
    }

}
