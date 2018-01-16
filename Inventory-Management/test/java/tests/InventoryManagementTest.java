package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import services.DaoService;
import services.DaoServiceImpl;
import services.DetectorService;
import services.ManageService;
import services.ManageServiceImpl;

public class InventoryManagementTest {
//Tests to verify if the manager service to validate the input statements and their format is working.
	@Test
	public void InputStatementtest1() {
		ManageService manage = new ManageServiceImpl();
		String input = "create gems blah 20.50";
		String[] splitStr = input.split(" ");
		boolean b = manage.manage(splitStr);
		
		assertEquals(false,b);
	}
	
	@Test
	public void InputStatementtest2() {
		ManageService manage = new ManageServiceImpl();
		String input = "updateSell gems 20.50";
		String[] splitStr = input.split(" ");
		boolean b = manage.manage(splitStr);
		
		assertEquals(false,b);
	}
	
	@Test
	public void InputStatementtest3() {
		ManageService manage = new ManageServiceImpl();
		String input = "report chicago";
		String[] splitStr = input.split(" ");
		boolean b = manage.manage(splitStr);
		
		assertEquals(false,b);
	}
	
	@Test
	public void InputStatementtest4() {
		ManageService manage = new ManageServiceImpl();
		String input = "why not?";
		String[] splitStr = input.split(" ");
		boolean b = manage.manage(splitStr);
		
		assertEquals(false,b);
	}
	
	@Test
	public void InputStatementtest5() {
		ManageService manage = new ManageServiceImpl();
		String input = "delete everything now";
		String[] splitStr = input.split(" ");
		boolean b = manage.manage(splitStr);
		
		assertEquals(false,b);
	}
	
	//Tests to verify if the DaoServices are working as expected.
	//These tests are dependent on the database being used.
	@Test
	public void Daotest1() {
		DetectorService detect = new DetectorService();
		String input = "create gems 10.50 20.50";
		String[] splitStr = input.split(" ");
		boolean b = detect.detect(splitStr);
		
		assertEquals(false,b);
	}
	
	@Test
	public void Daotest2() {
		DetectorService detect = new DetectorService();
		String input = "updateSell gems 20";
		String[] splitStr = input.split(" ");
		boolean b = detect.detect(splitStr);
		
		assertEquals(false,b);
	}
	
	@Test
	public void Daotest3() {
		DetectorService detect = new DetectorService();
		String input = "report";
		String[] splitStr = input.split(" ");
		boolean b = detect.detect(splitStr);
		
		assertEquals(true,b);
	}
	
	@Test
	public void Daotest4() {
		DetectorService detect = new DetectorService();
		String input = "what?";
		String[] splitStr = input.split(" ");
		boolean b = detect.detect(splitStr);
		
		assertEquals(false,b);
	}
	
	@Test
	public void Daotest5() {
		DetectorService detect = new DetectorService();
		String input = "delete crows";
		String[] splitStr = input.split(" ");
		boolean b = detect.detect(splitStr);
		
		assertEquals(false,b);
	}

}
