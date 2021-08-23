package com.openclassrooms.store;

public class Screen extends Item {

    protected String resolution;

    public Screen(Brand brand, double price, String resolution) {
        super(brand,price);
        this.resolution = resolution;
    }

}
