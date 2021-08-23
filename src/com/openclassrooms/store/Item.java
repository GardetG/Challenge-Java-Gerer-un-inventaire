package com.openclassrooms.store;

public class Item {
	
    protected Brand brand;
    protected double price;

    public Item(Brand brand, double price) {
        this.brand = brand; // Updating brand field
        this.price = price; // Updating price field
    }

}
