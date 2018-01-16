package services;

import java.util.ArrayList;
import java.util.List;

import models.Item;

public class DetectorService {
	public boolean detect(String[] splitStr){
		
		DaoService service = new DaoServiceImpl();
		boolean boo = false;
	//create
	if(splitStr[0].equals("create")){
		
			//Call Create Service
				 boo = service.create(splitStr);
				if(boo==true){
					System.out.println("Create Successful!");
					return true;
				}
				else{
					System.out.println("Create Failed!");}
				
	}
	
//delete		
	else if(splitStr[0].equals("delete")){
		boo = service.delete(splitStr);
			if(boo==true){
				System.out.println("Delete Successful!");
				return true;
			}
			else{
				System.out.println("Delete Failed!");
				return false;
			}
	}
	
	//updateBuy
	else if(splitStr[0].equals("updateBuy")){
			//Call UpdateBuy Service
				boo = service.updateBuy(splitStr);
				if(boo==true){
					System.out.println("Buy Successful!");
					return true;
				}
				else{
					System.out.println("Buy Failed!");
					return false;
				}
	}
	
	//updateSell
	else if(splitStr[0].equals("updateSell")){
				//Call UpdateBuy Service
				boo = service.updateSell(splitStr);
				if(boo==true){
					System.out.println("Sell Successful!");
					return true;
				}
				else{
					System.out.println("Sell Failed!");
					return false;
				}
	}
	
	//updateSellPrice
	else if(splitStr[0].equals("updateSellPrice")){
						//Call UpdateBuy Service
				boo = service.updateSellPrice(splitStr);
				if(boo==true){
					System.out.println("Update Successful!");
					return true;
				}
				else{
					System.out.println("Update Failed!");
					return false;
				}
	}
	
	//report
	else if(splitStr[0].equals("report")& splitStr.length==1){	
		List<Item> items = new ArrayList<Item>();
		items = service.report(splitStr);
		System.out.println("ItemName  BoughtAt  SoldAt AvailableQty  TotalValue");
		System.out.println("--------  --------   -----  -----------   ---------");
	items.forEach(i -> {System.out.println(i.getName()+"       "+i.getCost()+"       "+i.getSell()+"       "+i.getQty()+"          "+i.getCost()*i.getQty());});
	double totalvalue = 0;
	for(int i=0; i<items.size(); i++){
		totalvalue += items.get(i).getQty()*items.get(i).getCost();
	}
	System.out.println("-------------------------------------------------------------");
	System.out.println("Total Value: "+"                                      "+totalvalue);
	return true;
	}
	
	else{
		System.out.println("Invalid Input! Please check you input statement and try again.");
		return false;
	}
	return boo;
	
}
}
