package com.openclassrooms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import com.openclassrooms.store.Inventory;
import com.openclassrooms.store.Item;

/**
 * Implement IIventoryWriter to write inventory into a file.
 * 
 */

public class WriteInventoryInFile implements IInventoryWriter {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file to write Inventory strings in
	 * it, one per line
	 */
	public WriteInventoryInFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void PostInventory(Inventory inventory) {
		FileWriter writer;
		try {
			writer = new FileWriter(filepath);

			Map<Item, Integer> inventoryList = inventory.items;

			for (Entry<Item, Integer> entry : inventoryList.entrySet()) {
				String description = "";
				Item item = entry.getKey();
				description += item.Parse();
				int quantity = entry.getValue();
				description += " "+quantity;
				writer.write(description + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
