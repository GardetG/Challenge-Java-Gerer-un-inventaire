package com.openclassrooms;

import java.util.List;

/**
 * Interface implemented by a class which retrieve inventory data from a data
 * source.
 */
public interface IInventoryReader {
	/**
	 * 
	 * If no data is available, return an empty List
	 * 
	 * @return Raw string list of inventory's entry
	 */
	List<String> GetInventory();
}
