package services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import models.Item;

public class ManageServiceImpl implements ManageService {
//Verifying if the given input statement is valid 
	public boolean manage(String[] splitStr) {
		boolean boo = false;
		
		//create
		if(splitStr[0].equals("create")){
			if(splitStr.length == 4){
				if(isDouble(splitStr[2]) & isDouble(splitStr[3])){
					return true;
				}
				else{
					System.out.println("Invalid Datatypes given for item price. Please check and try again.");
				return false;
				}
			}
		}
		
//delete		
		else if(splitStr[0].equals("delete")){
			if(splitStr.length == 2){
				return true;
			}
		}
		
		//updateBuy
		else if(splitStr[0].equals("updateBuy")){
			if(splitStr.length == 3){
				if(isInteger(splitStr[2])){
					return true;
				}
				else{
					System.out.println("Invalid Datatypes given for item quantity. Please check and try again.");
					return false;
				}
			}
		}
		
		//updateSell
		else if(splitStr[0].equals("updateSell")){
			if(splitStr.length == 3){
				if(isInteger(splitStr[2])){
					return true;
				}
				else{
					System.out.println("Invalid Datatypes given for item quantity. Please check and try again.");
					return false;
				}
			}
		}
		
		//updateSellPrice
		else if(splitStr[0].equals("updateSellPrice")){
			if(splitStr.length == 3){
				if(isDouble(splitStr[2])){
			return true;
				}
				else{
					System.out.println("Invalid Datatypes given for item price. Please check and try again.");
					return false;
				}
			}
		}
		
		//report
		else if(splitStr[0].equals("report")& splitStr.length==1){	
			return true;
		}
		
		else{
			System.out.println("Invalid Input! Please check you input statement and try again.");
			return false;
		}
		return boo;
		
	}
	
	//verifying if required values in the given input statement are of type 'Double'
	 public static boolean isDouble(String s) {
	      boolean isValidDouble = false;
	      try
	      {
	    	  Double.parseDouble(s);	 
	         isValidDouble = true;
	      }
	      catch (NumberFormatException ex)
	      {
	System.out.println(ex);
	      }
	 
	      return isValidDouble;
	   }
	 
	//verifying if required values in the given input statement are of type 'Integer'
	 public static boolean isInteger(String s) {
	      boolean isValidInteger = false;
	      try
	      {
	    	  Integer.parseInt(s);	 
	         isValidInteger = true;
	      }
	      catch (NumberFormatException ex)
	      {
	System.out.println(ex);
	      }
	 
	      return isValidInteger;
	   }

}
