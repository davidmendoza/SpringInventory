package com.spring.main;

import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Inventory;
import com.spring.beans.ItemDetails;

public class InventoryMenu {
	
	private static final int ADD_NEW_ITEM = 1;
	private static final int DELETE_ITEM = 2;
	private static final int SUBTRACT_ITEM_STOCK = 3;
	private static final int ADD_ITEM_STOCK = 4;
	
	public static void start(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	    Inventory inventory = (Inventory) context.getBean("inventory");
	    Map<String, ItemDetails> inventoryMap = inventory.getInventoryMap();
		int choice;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("------ Apple Store ------");
			Logic.printItems(inventoryMap);
			System.out.println("[1] Add New Item");
			System.out.println("[2] Delete Item");
			System.out.println("[3] Subtract Item Stock");
			System.out.println("[4] Add Item Stock");
			System.out.println("[0] Exit");
			System.out.print("--> ");
			choice = checkIntInput(sc);
			
			switch(choice){
				
			case ADD_NEW_ITEM:
				Logic.addItem(inventoryMap);
			break;
			
			case DELETE_ITEM:
			    Logic.deleteItem(inventoryMap);
			break;
			
			case SUBTRACT_ITEM_STOCK:
				Logic.subtractItemStock(inventoryMap);
			break;
			
			case ADD_ITEM_STOCK:
				Logic.addItemStock(inventoryMap);
			break;
			
			default:
			break;
			}
		} while (choice != 0);
	}
	
	public static int checkIntInput(Scanner sc){
		
		int choice;
		while (!sc.hasNextInt()){
			System.out.print("\tPlease enter a valid number --> ");
			sc.next();
		}
		
		choice = sc.nextInt();
		
		return choice;
	}
}
