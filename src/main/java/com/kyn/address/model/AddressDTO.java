package com.kyn.address.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class AddressDTO {

    private UUID id;

    private UUID locality;
}
