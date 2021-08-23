package com.openclassrooms.store;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

	public Map<Item,Integer> items = new HashMap<>();
    
    public Inventory() {
    	items = new HashMap<>();
    }
    
    public void addItem(Item itemToAdd, int quantity) {
    	if (items.containsKey(itemToAdd)) {
    		quantity=items.get(itemToAdd) + quantity;
    	} 
    	items.put(itemToAdd, quantity);
    }
    
    public void removeItem(Item itemToRemove,int quantity) {
    	if (items.containsKey(itemToRemove)) {
    		quantity=items.get(itemToRemove)- quantity;
    		if (quantity <=0) {
    			items.remove(itemToRemove);
    		}else {
    			items.put(itemToRemove,quantity);
    		}
    		
    	}
    }
    
    public void displayInventoryOnConsole() {
    	System.out.println(" --- Inventory --- ");
        items.forEach((item, quantity) ->
        System.out.println((item.getClass().getSimpleName() + " - " + item.brand + ":" + quantity)));
    }

}
