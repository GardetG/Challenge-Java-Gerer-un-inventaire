package com.openclassrooms;

import java.util.List;

import com.openclassrooms.store.Brand;
import com.openclassrooms.store.Inventory;
import com.openclassrooms.store.Mouse;
import com.openclassrooms.store.Screen;

public class Main {

	public static void main(String[] args) {

		IInventoryReader inventoryReader = new ReadInventoryFromFile("inventory.inv");
		List<String> inventoryList = inventoryReader.GetInventory();

		Inventory inventory = new Inventory();

		for (String entry : inventoryList) {
			String[] parsedEntry = entry.split(";");
			switch (parsedEntry[0]) {
			case "Mouse":
				Mouse mouseToAdd = new Mouse(parsedEntry[1], Brand.valueOf(parsedEntry[2]),
						Double.parseDouble(parsedEntry[3]));
				inventory.addItem(mouseToAdd,Integer.parseInt(parsedEntry[4]));
				break;

			case "Screen":
				Screen screenToAdd = new Screen(parsedEntry[1], Brand.valueOf(parsedEntry[2]),
						Double.parseDouble(parsedEntry[3]), parsedEntry[4]);
				inventory.addItem(screenToAdd,Integer.parseInt(parsedEntry[5]));
				break;

			default:
				System.out.println("Invalid Item");
			}
		}

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
		
		IInventoryWriter inventoryWriter=new WriteInventoryInFile("inventory.inv");
		inventoryWriter.PostInventory(inventory);
	}
}
