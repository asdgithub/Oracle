/**
 * 
 */
package controller;

/**
 * @author Ashleigh Davis
 *
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

import model.WoodItem;

public class HardwoodSeller {

	/**
	 * @param args
	 */

	String buyerName;
	String buyerAddr;
	String buyerDate;
	static ArrayList<WoodItem> items;
	static ArrayList<Integer> boardFoot;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filePath;

		int count = 0;

		double total = 0.00;

		Scanner in = new Scanner(System.in);

		if(args.length == 0){
			System.out.println("Enter file path for order:");
			filePath = in.next();
		}else{
			filePath = args[0];
		}

//		System.out.println("File path: " + filePath);

		HardwoodSeller h = new HardwoodSeller();
		h.readInputFile(filePath);

		System.out.println("###############################################################################");
		System.out.println("\nNEW ORDER");
		System.out.println("Name: " + h.buyerName);
		System.out.println("Address: " + h.buyerAddr);
		System.out.println("Date: " + h.buyerDate + "\n");
		System.out.println("Items:");

		//Loop through items: Display type, BF purchased, and price per BF
		while(count < items.size() && items.size() == boardFoot.size()){
			if(boardFoot.get(count) > 1000){
				System.out.print(items.get(count).toString() + " * " + 1000 + " BF (Max Purchase: 1000 BF)\n");
			}else if(boardFoot.get(count) <= 0){
				System.out.print(items.get(count).toString() + " * " + 0 + " BF (Min Purchase: 1 BF) - VOID\n");
			}else{
				System.out.print(items.get(count).toString() + " * " + boardFoot.get(count) + " BF\n");
			}
				
			total += items.get(count).getPrice() * boardFoot.get(count);	
			count++;
		}


		System.out.println("\nEstimated delivery time: " + h.deliveryTime() + " hours");
		System.out.println("\nTOTAL: $" + total + "\n");
		System.out.println("###############################################################################");


		items.clear();
		boardFoot.clear();

//		System.out.println("Size of items arraylist: " + items.size());
//		System.out.println("Size of bf arraylist: " + boardFoot.size());
	}
	
	public void readInputFile(String inputFilePath){
		File theFile = new File(inputFilePath);
		Scanner fileScan;

		String line;
		String[] buyerInfo;
		String[] woodItemInfo;
		String woodType = "";

		int bf = 0;

		double baseDelTime = 0.0;
		double price = 0.0;

		items = new ArrayList<WoodItem>();
		boardFoot = new ArrayList<Integer>();

		try{
			fileScan = new Scanner(theFile);
			fileScan.useDelimiter(";");
			line = fileScan.nextLine();
			buyerInfo = line.split(";");

			buyerName = buyerInfo[0];
			buyerAddr = buyerInfo[1];
			buyerDate = buyerInfo[2];

			while(fileScan.hasNext()){
				line = fileScan.next();

//				System.out.println(line);

				woodItemInfo = line.split(":");

//				System.out.println("Wood type: " + woodItemInfo[0]);
//				System.out.println("BF: " + woodItemInfo[1]);

				bf = Integer.parseInt(woodItemInfo[1]);

//				System.out.println(bf);

				if(woodItemInfo[0].equals("Cherry")){
					woodType = "Cherry";
					baseDelTime = 2.5;
					price = 5.95;
				}
				if(woodItemInfo[0].equals("Curly Maple")){
					woodType = "Curly Maple";
					baseDelTime = 1.5;
					price = 6.00;
				}
				if(woodItemInfo[0].equals("Genuine Mahogany")){
					woodType = "Genuine Mahogany";
					baseDelTime = 3;
					price = 9.60;
				}
				if(woodItemInfo[0].equals("Wenge")){
					woodType = "Wenge";
					baseDelTime = 5;
					price = 22.35;
				}
				if(woodItemInfo[0].equals("White Oak")){
					woodType = "White Oak";
					baseDelTime = 2.3;
					price = 6.70;
				}
				if(woodItemInfo[0].equals("Sawdust")){
					woodType = "Sawdust";
					baseDelTime = 1;
					price = 1.50;
				}

//				System.out.println(woodType);
//				System.out.println(baseDelTime);
//				System.out.println(price);

				WoodItem theItem = new WoodItem(woodType, baseDelTime, price);

				items.add(theItem);

				boardFoot.add(bf);
			}

//			System.out.println("Number of items in WoodItem arraylist: " + items.size());
//			System.out.println("Number of bf's in bf arraylist: " + boardFoot.size());

		}catch(Exception e){
			System.out.println(e.toString());
		}

//		System.out.println(buyerName);
//		System.out.println(buyerAddr);
//		System.out.println(buyerDate);

//		System.out.println(items.get(0).getType());
//		System.out.println(items.get(0).getBaseDeliveryTime());
//		System.out.println(items.get(0).getPrice());

	}
	
	public double deliveryTime(){
		double deliveryETA = 0.0;

		int count = 0;
		int bf;
		double multiplier = 0.00;

		while(count < items.size()){
			bf = boardFoot.get(count);
			if(bf <= 0){

			}

			if(1 <= bf && bf <= 100){
				multiplier = 1;
			}

			if(101 <= bf && bf <= 200){
				multiplier = 2;
			}

			if(201 <= bf && bf <= 300){
				multiplier = 3;
			}

			if(301 <= bf && bf <= 400){
				multiplier = 4;
			}

			if(401 <= bf && bf <= 500){
				multiplier = 5;
			}

			if(501 <= bf && bf <= 1000){
				multiplier = 5.5;
			}

			if(bf > 1000){
				multiplier = 5.5;
			}

			if(count == 0){
				deliveryETA = items.get(count).getBaseDeliveryTime() * multiplier;
			}

			if((items.get(count).getBaseDeliveryTime() * multiplier) > deliveryETA){
				deliveryETA = items.get(count).getBaseDeliveryTime() * multiplier;
			}

			count++;
		}

		return deliveryETA;
	}
	
}
