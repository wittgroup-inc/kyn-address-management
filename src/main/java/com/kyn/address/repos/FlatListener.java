package com.kyn.address.repos;

import java.util.UUID;

import com.kyn.address.domain.Flat;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class FlatListener extends AbstractMongoEventListener<Flat> {

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<Flat> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(UUID.randomUUID());
        }
    }

}
