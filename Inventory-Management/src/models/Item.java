package models;

public class Item {
private String name;
private int qty;
private double sell;
private double cost;
public Item() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public double getSell() {
	return sell;
}
public void setSell(double sell) {
	this.sell = sell;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
}
