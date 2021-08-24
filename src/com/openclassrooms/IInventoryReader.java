package com.openclassrooms;

import java.util.List;

/**
 * Interface for class which read inventory from a data source and return
 * a raw string list.
 */
public interface IInventoryReader {
	/**
	 * 
	 * If no data is available, return an empty List
	 * 
	 * @return Raw string list of inventory
	 */
	List<String> GetInventory ();
}
