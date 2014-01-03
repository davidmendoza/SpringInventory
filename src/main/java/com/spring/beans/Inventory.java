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
	
	public void printItems(Map<String, ItemDetails> inventory){
		
		System.out.println("Name - Price - Quantity");
		for(Map.Entry<String, ItemDetails> entry : inventory.entrySet()){
			System.out.println(entry.getKey()+" - "+entry.getValue().getPrice()+" - "+entry.getValue().getQuantity());
		}
	}
	
	
	
}
