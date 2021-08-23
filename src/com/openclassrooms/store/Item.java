package com.openclassrooms.store;

/**
 * Item that are managed by the inventory and identify by ref
 */
public abstract class Item {

	protected String reference;
	protected Brand brand;
	protected double price;

	public Item(String reference, Brand brand, double price) {
		this.reference=reference;
		this.brand = brand; // Updating brand field
		this.price = price; // Updating price field
	}

}
