package com.openclassrooms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadInventoryFromFile implements IInventoryReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with Inventory strings in it, one per line
	 */
	public ReadInventoryFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetInventory() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
