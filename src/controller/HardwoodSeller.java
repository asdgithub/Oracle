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

		int maxDelivery;

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

				if(bf > 1000){
					System.out.println("Too much requested. Placing order for 1000 BF of " + woodItemInfo[0]);
					boardFoot.add(1000);
				}
				if(bf <= 0){
					System.out.println("0 BF of " + woodItemInfo[0]);
					boardFoot.add(0);
				}

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
	
	public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}
	
}
