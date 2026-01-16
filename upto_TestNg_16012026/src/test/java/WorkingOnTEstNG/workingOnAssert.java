package WorkingOnTEstNG;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;

public class workingOnAssert {
	public void createAdminTest()
	{
		Reporter.log("---------------------TEST CASE 1----------------", true);
		Reporter.log("Step-1", true);
		Reporter.log("Step-2", true);

		String val1 = "Home";
		assertEquals(true, val1); // its correct continue execution

		Reporter.log("Step-3", true);

		boolean val2 = false;
		assertEquals(true, val2);

		Reporter.log("Step-4", true);
		Reporter.log("Step-5", true);

	}
	/*
	public void modifyAdminTest()
	{
		Reporter.log("---------------------TEST CASE 2----------------", true);

		boolean val2 = false;
		assertEquals(true, val2);

		Reporter.log("Step-4", true);
		Reporter.log("Step-5", true);		
	
	}
	
	public void deleteOrderTest()
	{
		Reporter.log("---------------------TEST CASE 3-----------------", true);
		Reporter.log("Step-1", true);
		Reporter.log("Step-2", true);

		String val1 = "Home";
		assertEquals(true, val1); // its correct continue execution

		Reporter.log("Step-3", true);
	
	}
*/
}
