package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Item;
import models.Datasource;
import models.DBconnection;

public class DaoServiceImpl implements DaoService {
	//Establishing Connection to the Relevant Database using DataSource and Connection Objects.
	Datasource ds = new Datasource();
	Connection con = DBconnection.getConnection(ds);
	PreparedStatement stm = null;
	PreparedStatement st = null;
	//Create DAO
public boolean create(String[] s){
	String sql = "Insert into items(name,cost,sell,qty) values(?,?,?,0)";
	try{
		stm = con.prepareStatement(sql);
stm.setString(1, s[1]);
stm.setDouble(3, Double.parseDouble(s[3]));
stm.setDouble(2, Double.parseDouble(s[2]));
	try {
		int rowsAffected = stm.executeUpdate();
	if(rowsAffected>0){
		return true;
	}
		}
	catch (SQLException e) {
		e.printStackTrace();
	}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println("Create DAO called");
	return false;
}

//Delete DAO
public boolean delete(String[] s){
	String sql = "delete from items where name=?";
	try{
		stm = con.prepareStatement(sql);
		stm.setString(1, s[1]);
	try {
		int rowsAffected = stm.executeUpdate();
	if(rowsAffected>0){
		return true;
	}
		}
	catch (SQLException e) {
		e.printStackTrace();
	}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

//updateBuyQty
public boolean updateBuy(String[] s){
	String sql = "update items set qty=? where name=?";
	String qq = "insert into transactions(itemid,qty,type,total) values(?,?,'b',?)";
	String sq = "select qty,id,cost from items where name=?";
	int q = 0;
	int id = 0;
	double cost = 0;
	try{
		stm = con.prepareStatement(sq);
		stm.setString(1, s[1]);
		try{
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			 q = rs.getInt(1);
			 id = rs.getInt(2);
			 cost = rs.getDouble(3);
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	try{
		stm = con.prepareStatement(sql);
		st = con.prepareStatement(qq);
		stm.setString(2, s[1]);
		int qt = q+Integer.parseInt(s[2]);
		stm.setInt(1, qt);
		double total = cost*Integer.parseInt(s[2]);
		st.setInt(1, id);
		st.setInt(2, Integer.parseInt(s[2]));
		st.setDouble(3, total);
	try {
		int rowsAffected = stm.executeUpdate();
		int rowsAffected1 = st.executeUpdate();
	if(rowsAffected>0 & rowsAffected1>0){
		return true;
	}
		}
	catch (SQLException e) {
		e.printStackTrace();
	}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

//updateSellQty
public boolean updateSell(String[] s){
	String sql = "update items set qty=? where name=?";
	String qq = "insert into transactions(itemid,qty,type,total) values(?,?,'s',?)";
	String sq = "select qty,id,sell from items where name=?";
	int q = 0;
	int id = 0;
	double sell = 0;
	try{
		stm = con.prepareStatement(sq);
		stm.setString(1, s[1]);
		try{
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			 q = rs.getInt(1);
			 id = rs.getInt(2);
			 sell = rs.getDouble(3);
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	try{
		stm = con.prepareStatement(sql);
		st = con.prepareStatement(qq);
		stm.setString(2, s[1]);
		int qt = q-Integer.parseInt(s[2]);
		if(qt<0){
			System.out.println("Trying to sell more than available quantity!");
			return false;
		}
		double total = sell*Integer.parseInt(s[2]);
		stm.setInt(1, qt);
		st.setInt(1, id);
		st.setInt(2, Integer.parseInt(s[2]));
		st.setDouble(3, total);
	try {
		int rowsAffected = stm.executeUpdate();
		int rowsAffected1 = st.executeUpdate();
	if(rowsAffected>0 & rowsAffected1>0){
		return true;
	}
		}
	catch (SQLException e) {
		e.printStackTrace();
	}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

//updateSellPrice
public boolean updateSellPrice(String[] s){
	String sql = "update items set sell=? where name=?";
	
	try{
		stm = con.prepareStatement(sql);
		stm.setString(2, s[1]);
		stm.setDouble(1, Double.parseDouble(s[2]));
	try {
		int rowsAffected = stm.executeUpdate();
	if(rowsAffected>0){
		return true;
	}
		}
	catch (SQLException e) {
		e.printStackTrace();
	}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

//Report----
public List<Item> report(String[] s){
	String sq = "select max(last) from reports";//retrieving  time stamp of last generated report from 'reports' table.
	String sql = "select * from items";
//	Calendar calendar = Calendar.getInstance();
	Date date = new Date();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	List<Item> items = new ArrayList<Item>();
	try{
		stm = con.prepareStatement(sql);
		st = con.prepareStatement(sq);
		try{
		ResultSet rs = stm.executeQuery();
		ResultSet rs1 = st.executeQuery();
		while(rs.next()){
			Item item = new Item();
			item.setName(rs.getString(2));
			item.setCost(rs.getDouble(3));
			item.setSell(rs.getDouble(4));
			item.setQty(rs.getInt(5));
			items.add(item);
		}
		while(rs1.next()){
			date = rs1.getTimestamp(1);
		}
		/*
		 * If date is null i.e no reports generated, set date as '0000-00-00'
		 */
		if(date==null){
			try {
				date =  df.parse("0000-00-00");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(date);
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	
	/*
	 * Retrieving all SumTotal of all Sell and Buy Transactions since last report generation 
	 */
	
	String bqc = "select sum(total) from transactions where type='b'and date>?";
	String sqc = "select sum(total) from transactions where type='s' and date>?";
	String z = "insert into reports() values()";
	double buytotal = 0;
	double selltotal = 0;
	double profit = 0;
	try{
		stm = con.prepareStatement(bqc);
		
		stm.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
		st = con.prepareStatement(sqc);
		st.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
		try{
		ResultSet rs = stm.executeQuery();
		ResultSet rs1 = st.executeQuery();
		while(rs.next()){
		buytotal = rs.getDouble(1);
		}
		while(rs1.next()){
			selltotal = rs1.getDouble(1);
		}
	profit = selltotal - buytotal;
	System.out.println("Profit from the last report is: "+profit);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	try{
		stm = con.prepareStatement(z);
		try{
			int flag = stm.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return items;
	
}

}
