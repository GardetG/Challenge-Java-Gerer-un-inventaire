package com.openclassrooms.store;

public class Mouse extends Item {

	public Mouse(String reference,Brand brand, double price) {
    	super(reference,brand, price);
    }
	
    @Override
    public String Parse() {
    	String Output = super.Parse();
    	return Output;
    }
}
