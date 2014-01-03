package com.spring.main;

import java.util.Map;
import java.util.Scanner;

import com.spring.beans.ItemDetails;

public class DataAccess {
	
	public static void printItems(Map<String, ItemDetails> inventory){
		
		System.out.println("Name - Price - Quantity");
		for(Map.Entry<String, ItemDetails> entry : inventory.entrySet()){
			System.out.println(entry.getKey()+" - "+entry.getValue().getPrice()+" - "+entry.getValue().getQuantity());
		}
		
	}
	
	public static void AddItem(Map<String, ItemDetails> inventory){
		Scanner sc = new Scanner(System.in);
		String name;
		int quantity;
		int price;
		ItemDetails itemDetails = new ItemDetails();
		
		System.out.println("\tAdd new Item");
		System.out.print("\tEnter Item Name --> ");
		name = sc.nextLine();
		System.out.print("\tEnter price --> ");
		price = InventoryMenu.checkIntInput(sc);
		System.out.print("\tEnter quantity --> ");
		quantity = InventoryMenu.checkIntInput(sc);
		
		itemDetails.setPrice(price);
		itemDetails.setQuantity(quantity);
		
		inventory.put(name, itemDetails);
		System.out.println("\tItem "+name+" added");
	}
	
	public void takeItem(Map<String, ItemDetails> inventory){
		
	}
}
