package main;

import java.text.ParseException;
import java.util.Scanner;

import services.DaoService;
import services.DaoServiceImpl;
import services.DetectorService;
import services.ManageService;
import services.ManageServiceImpl;

public class InventoryManagement {
//Main File
	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your command statement");
		String input = in.nextLine();
		String[] splitStr = input.split(" ");
		ManageService manager = new ManageServiceImpl();
		DetectorService detect = new DetectorService();
boolean bool = manager.manage(splitStr);
boolean boo;
if(bool==true)
	 boo = detect.detect(splitStr);
	}
	}

