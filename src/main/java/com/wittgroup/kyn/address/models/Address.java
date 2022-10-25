package com.wittgroup.kyn.address.models;

import lombok.Data;

import java.util.UUID;


@Data
public class Address {

    private UUID id;

    private Flat flat;

    private Apartment apartment;

    private Locality locality;

}
