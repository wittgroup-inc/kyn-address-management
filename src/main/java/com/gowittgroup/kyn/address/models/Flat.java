package com.gowittgroup.kyn.address.models;

import lombok.Data;

import javax.validation.constraints.Size;


@Data
public class Flat {

    @Size(max = 255)
    private String flatNumber;

    @Size(max = 255)
    private String tower;

    @Size(max = 255)
    private String floor;

    public static final Flat EMPTY = new Flat();

}