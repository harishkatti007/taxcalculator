package com.hk.pricing.taxcalculator.model;

/**
 * Created by tech on 29/11/17.
 */
public enum Categories {

    BOOKS("Books"),
    MUSIC_CD("MusicCD"),
    CHOCOLATES("Chocolates"),
    ALCOHOL("Alcohol"),
    MEDICINES("Medicines"),
    ACCESSORIES("Accessories");

    private String name;

    Categories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
