package com.openclassrooms;

import com.openclassrooms.store.Inventory;

/**
 * 
 * Interface for class which write in a data source the current inventory to
 * persist.
 *
 */
public interface IInventoryWriter {
	/**
	 * 
	 * @param inventory to persist
	 */
	void PostInventory(Inventory inventory);
}
