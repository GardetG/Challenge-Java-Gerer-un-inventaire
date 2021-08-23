package com.openclassrooms.store;

import java.util.HashMap;
import java.util.Map;

/**
 * Manage items and quantity of them Can display all items on the console
 */
public class Inventory {

	public Map<Item, Integer> items = new HashMap<>();

	public Inventory() {
		items = new HashMap<>();
	}

	/**
	 * Add items to this inventory
	 * 
	 * @param itemToAdd Item to add to the inventory
	 * @param quantity  Quantity to add
	 */
	public void addItem(Item itemToAdd, int quantity) {
		if (items.containsKey(itemToAdd)) {
			quantity = items.get(itemToAdd) + quantity;
		}
		items.put(itemToAdd, quantity);
	}
	
	public void addItem(Item itemToAdd) {
		this.addItem(itemToAdd,1);
	}

	/**
	 * Remove items to this inventory
	 * 
	 * @param itemToRemove Item to remove from this inventory
	 * @param quantity     Quantity to remove
	 */
	public void removeItem(Item itemToRemove, int quantity) {
		if (items.containsKey(itemToRemove)) {
			quantity = items.get(itemToRemove) - quantity;
			if (quantity <= 0) {
				items.remove(itemToRemove);
			} else {
				items.put(itemToRemove, quantity);
			}

		}
	}
	public void removeItem(Item itemToRemove) {
		this.removeItem(itemToRemove, 1);
	}
	/**
	 * Display on console the list of items in inventory and their quantity
	 */
	public void displayInventoryOnConsole() {
		System.out.println(" --- Inventory --- ");
		items.forEach((item, quantity) -> System.out
				.println((item.getClass().getSimpleName() + " - " + item.reference + ":" + quantity)));
	}
	/**
	 * Display on console the list of items 
	 */
	public void displayItemsOnConsole() {
		System.out.println(" --- Items in stock --- ");
		items.forEach((item, quantity) -> System.out
				.println((item.getClass().getSimpleName() + " - " + item.reference+ " - "+item.brand + ":" + item.price)));
	}

}
