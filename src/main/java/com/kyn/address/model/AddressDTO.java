package com.kyn.address.model;

import com.kyn.address.domain.Apartment;
import com.kyn.address.domain.Flat;
import com.kyn.address.domain.Locality;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class AddressDTO {

    private UUID id;

    private Flat flat;

    private Apartment apartment;

    private Locality locality;

}
