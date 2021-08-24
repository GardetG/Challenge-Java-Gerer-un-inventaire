package com.openclassrooms;

import java.util.List;

import com.openclassrooms.store.Brand;
import com.openclassrooms.store.Inventory;
import com.openclassrooms.store.Item;
import com.openclassrooms.store.Mouse;
import com.openclassrooms.store.Screen;

public class Main {

	public static void main(String[] args) {

		IInventoryReader inventoryReader = new ReadInventoryFromFile("inventory.inv");
		List<String> inventoryList = inventoryReader.GetInventory();

		Inventory inventory = new Inventory();

		for (String entry : inventoryList) {
			String[] parseEntry = entry.split(" ");
			Item item = CreateItem(parseEntry[0]);
			int quantity = Integer.parseInt(parseEntry[1])  ;
			if (!(item == null)) {
				inventory.addItem(item, quantity);
			}
		}

		if (!(args.length == 0)) {
			switch (args[0]) {
			case "inventory": {
				inventory.displayInventoryOnConsole();
				break;
			}
			case "items": {
				inventory.displayItemsOnConsole();
				break;
			}
			case "add": {
				int quantity = 1;
				if (args.length > 2) {
					quantity = Integer.parseInt(args[2]);
				}
				Item itemToAdd = CreateItem(args[1]);
				if (!(itemToAdd == null)) {
					inventory.addItem(itemToAdd, quantity);
				}
				IInventoryWriter inventoryWriter = new WriteInventoryInFile("inventory.inv");
				inventoryWriter.PostInventory(inventory);
				break;
			}
			case "remove": {
				int quantity = 1;
				if (args.length > 2) {
					quantity = Integer.parseInt(args[2]);
				}
				Item itemToRemove = CreateItem(args[1]);
				if (!(itemToRemove == null)) {
					inventory.removeItem(itemToRemove, quantity);
				}
				IInventoryWriter inventoryWriter = new WriteInventoryInFile("inventory.inv");
				inventoryWriter.PostInventory(inventory);
				break;
			}
			default:{
				System.out.println("Invalid command");
			}
			}
		} else {
			Mouse dellMouse = new Mouse("08001", Brand.DELL, 20.0);
			Screen samsungScreen = new Screen("07001", Brand.SAMSUNG, 150.0, "1920x1080");

			inventory.addItem(samsungScreen, 5);

			inventory.addItem(dellMouse, 12);
			inventory.removeItem(dellMouse, 2);
			inventory.displayInventoryOnConsole();

			inventory.removeItem(dellMouse, 12);
			inventory.addItem(dellMouse, 2);

			inventory.displayInventoryOnConsole();
			inventory.displayItemsOnConsole();

			IInventoryWriter inventoryWriter = new WriteInventoryInFile("inventory.inv");
			inventoryWriter.PostInventory(inventory);
		}
	}

	public static Item CreateItem(String parsedItem) {
		Item outputItem;
		try {
			String[] parsedEntry = parsedItem.split(";");
			switch (parsedEntry[0]) {
			case "Mouse":
				outputItem = new Mouse(parsedEntry[1], Brand.valueOf(parsedEntry[2]),
						Double.parseDouble(parsedEntry[3]));
				break;
			case "Screen":
				outputItem = new Screen(parsedEntry[1], Brand.valueOf(parsedEntry[2]),
						Double.parseDouble(parsedEntry[3]), parsedEntry[4]);
				break;
			default:
				System.out.println("Invalid Item");
				outputItem = null;
			}
		} catch (Exception e) {
			System.out.println("Invalid Item's description");
			outputItem = null;
		}
		return outputItem;
	}
}
