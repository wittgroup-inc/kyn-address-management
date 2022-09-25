package com.kyn.address.repos;

import java.util.UUID;

import com.kyn.address.domain.Apartment;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class ApartmentListener extends AbstractMongoEventListener<Apartment> {

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<Apartment> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(UUID.randomUUID());
        }
    }

}
