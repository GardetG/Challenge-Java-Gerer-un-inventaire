package com.openclassrooms.store;

public class Screen extends Item {

    protected String resolution;

    public Screen(String reference,Brand brand, double price, String resolution) {
        super(reference,brand,price);
        this.resolution = resolution;
    }

}
