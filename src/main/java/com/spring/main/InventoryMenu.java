package com.spring.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Inventory;

public class InventoryMenu {
	
	private static final int ADD_NEW_ITEM = 1;
	
	public static void start(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	    Inventory inventory = (Inventory) context.getBean("inventory");
	    
	    System.out.println(inventory.getInventoryMap());
		int choice;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("------ Apple Store ------");
			DataAccess.printItems(inventory.getInventoryMap());
			System.out.println("[1] Add New Item");
			System.out.print("--> ");
			choice = checkIntInput(sc);
			
			switch(choice){
				
			case ADD_NEW_ITEM:
				DataAccess.AddItem(inventory.getInventoryMap());
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
