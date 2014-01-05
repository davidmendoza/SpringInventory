package com.spring.beans;

import java.util.Map;

public class Inventory {

	private Map<String, ItemDetails> inventoryMap;

	public Map<String, ItemDetails> getInventoryMap() {
		return inventoryMap;
	}

	public void setInventoryMap(Map<String, ItemDetails> inventoryMap) {
		this.inventoryMap = inventoryMap;
	}
	
}
