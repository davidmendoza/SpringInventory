package com.spring.main;

import java.util.Map;
import java.util.Scanner;

import com.spring.beans.ItemDetails;

public class Logic {
	
	public static void printItems(Map<String, ItemDetails> inventory){
		
		System.out.println("Name - Price - Quantity");
		for(Map.Entry<String, ItemDetails> entry : inventory.entrySet()){
			System.out.println(entry.getKey()+" - "+entry.getValue().getPrice()+" - "+entry.getValue().getQuantity());
		}
		
	}
	
	public static void addItem(Map<String, ItemDetails> inventoryMap){
		Scanner sc = new Scanner(System.in);
		String name;
		int quantity;
		int price;
		ItemDetails itemDetails = new ItemDetails();
		
		System.out.println("\tAdd new Item");
		System.out.print("\tEnter Item Name --> ");
		name = sc.nextLine().toUpperCase().trim();
		System.out.print("\tEnter price --> ");
		price = InventoryMenu.checkIntInput(sc);
		System.out.print("\tEnter quantity --> ");
		quantity = InventoryMenu.checkIntInput(sc);
		
		itemDetails.setPrice(price);
		itemDetails.setQuantity(quantity);
		
		inventoryMap.put(name, itemDetails);
		System.out.println("\tItem "+name+" added");
	}
	
	public static void deleteItem(Map<String, ItemDetails> inventoryMap){
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.print("\tEnter item name to delete --> ");
		name = sc.nextLine().toUpperCase().trim();
		
		if (inventoryMap.containsKey(name)){
			inventoryMap.remove(name);
			System.out.println("\tRemoved item");
		} else {
			System.out.println("Item does not exist");
		}
		
	}
	
	
	public static void subtractItemStock(Map<String, ItemDetails> inventoryMap){
		Scanner sc = new Scanner(System.in);
		String name;
		int num;
		int diff;
		int qty;
		
		System.out.print("\tEnter item name --> ");
		name = sc.nextLine().toUpperCase().trim();
		if (inventoryMap.containsKey(name)){
			ItemDetails item = inventoryMap.get(name);
			qty = item.getQuantity();
			System.out.println("\tItem Name - Quantity");
			System.out.println("\t"+name+" - "+qty);
			System.out.print("\tEnter number of items to subtract --> ");
			num = InventoryMenu.checkIntInput(sc);
			diff = qty - num;
			if (diff >= 0){
				item.setQuantity(diff);
				System.out.println("\tTransaction successful");
			} else {
				System.out.println("\tNegative balance. Transaction cancelled");
			}
		} else {
			System.out.println("\tItem not found");
		}
	}
	
	public static void addItemStock(Map<String, ItemDetails> inventoryMap){
		Scanner sc = new Scanner(System.in);
		String name;
		int num;
		int qty;
		
		System.out.print("\tEnter item name --> ");
		name = sc.nextLine().toUpperCase().trim();
		if (inventoryMap.containsKey(name)){
			ItemDetails item = inventoryMap.get(name);
			qty = item.getQuantity();
			System.out.println("\tItem Name - Quantity");
			System.out.println("\t"+name+" - "+qty);
			System.out.print("\tEnter number of items to add --> ");
			num = InventoryMenu.checkIntInput(sc);
			item.setQuantity(qty + num);
			System.out.println("\tTransaction successful");
		} else {
			System.out.println("\tItem not found");
		}
	}
	
	
}
