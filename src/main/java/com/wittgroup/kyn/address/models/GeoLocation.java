package com.wittgroup.kyn.address.models;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;


@Data
public class GeoLocation {

    @NotNull @NonNull
    private Long latitude;

    @NotNull @NonNull
    private Long longitude;

    public static final GeoLocation EMPTY = new GeoLocation(0L, 0L);
}
