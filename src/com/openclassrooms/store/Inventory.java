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
		this.addItem(itemToAdd, 1);
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

	private String formate(String entry, int length, boolean reverse) {
		while (entry.length() < length) {
			if (reverse) {
				entry += " ";
			} else {
				entry = " " + entry;
			}
		}
		return entry;
	}

	/**
	 * Display on console the list of items in inventory and their quantity
	 */
	public void displayInventoryOnConsole() {
		System.out.println(" ------ Inventory ------- ");
		System.out.println(" |Name      |Ref  |Qty  | ");
		System.out.println(" ------------------------ ");
		items.forEach((item, quantity) -> {
			String outtxt = " |";
			outtxt += formate(item.getClass().getSimpleName(), 10, true);
			outtxt += "|";
			outtxt += formate(item.reference, 5, false);
			outtxt += "|";
			outtxt += formate(Integer.toString(quantity), 5, false);
			outtxt+="|";
			System.out.println(outtxt);
		});
		System.out.println(" ------------------------ ");
	}

	/**
	 * Display on console the list of items
	 */
	public void displayItemsOnConsole() {
		System.out.println(" --- Items in stock --- ");
		items.forEach((item, quantity) -> System.out.println(
				(item.getClass().getSimpleName() + " - " + item.reference + " - " + item.brand + ":" + item.price)));
	}

}
