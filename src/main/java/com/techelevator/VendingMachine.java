package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.item.Chip;
import com.techelevator.item.Drink;

public class VendingMachine {
	
	private List<Item> inventoryList = new ArrayList<Item>();

	public VendingMachine() {

		String path = "vendingmachine.csv";
		File inventoryFile = new File(path);

		try (Scanner fileScanner = new Scanner(inventoryFile)) {

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] lineArray = line.split("\\|");

				if (lineArray[3].equals("Chip")) {
					for (int i = 0; i < 5; i++) {
						Item newChip = new Chip(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newChip);
					}
				}

				if (lineArray[3].equals("Candy")) {
					for (int i = 0; i < 5; i++) {
						Item newCandy = new Candy(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newCandy);
					}
				}

				if (lineArray[3].equals("Drink")) {
					for (int i = 0; i < 5; i++) {
						Item newDrink = new Drink(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newDrink);
					}
				}

				if (lineArray[3].equals("Gum")) {
					for (int i = 0; i < 5; i++) {
						Item newGum = new Gum(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]));
						inventoryList.add(newGum);
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
// Prints out the inventory list from the vending machine	
//	public void printOut() {
//		for (Item item : inventoryList) {
//			System.out.println(item.getSlotLocation() + " " + item.getProductName() + " " + item.getPrice() + " " + item.getType());
//		}
//	}
	

	public void displayInventory() {

	}

	public void feedMoney() {
		String dollarAmount = "";

		while (dollarAmount.equals("")) {
			System.out.println("Please enter your dollar amount (e.g. 1, 2, 5, 10) ");
			String dollarInput = userInput.nextLine();

			if (dollarInput.equals("1") || dollarInput.equals("2") || dollarInput.equals("5")
					|| dollarInput.equals("10")) {
				dollarAmount = dollarInput;

			}
		}

		purchaseMenu();
	}

	public void selectProduct() {

		purchaseMenu();
	}

	public void finishTransaction() {

	}

}
