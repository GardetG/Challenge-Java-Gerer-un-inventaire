package com.openclassrooms.store;

import java.util.Objects;

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

	public String Parse() {
		String Output="";
		Output+=this.getClass().getSimpleName()+";";
		Output+=this.reference+";";
		Output+=this.brand+";";
		Output+=this.price+";";
		return Output;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, price, reference);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return brand == other.brand && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(reference, other.reference);
	}


	
	
}
