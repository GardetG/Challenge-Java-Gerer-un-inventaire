package com.openclassrooms;

import com.openclassrooms.store.Inventory;

/**
 * Interface implemented by a class which write in a data source the current
 * inventory.
 *
 */
public interface IInventoryWriter {
	/**
	 * 
	 * @param Inventory to write in data source.
	 */
	void PostInventory(Inventory inventory);
}
