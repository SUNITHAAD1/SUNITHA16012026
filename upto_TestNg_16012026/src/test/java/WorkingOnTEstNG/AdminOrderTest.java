package WorkingOnTEstNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;
import com.Comcast.Crm.BaseClass.Configuration_BaseClass;

public class AdminOrderTest extends Configuration_BaseClass {
	/*
	 (groups = {"SmokeTest","RegressionTest"})
	 */
	@Test (groups="SmokeTest")
	public void createAdminTest()
	{
		Reporter.log("Admin created successfully",true);
	}
	
	@Test(groups ="RegressionTest" )
	public void modifyAdminTest()
	{
		Reporter.log("Admin modified successfully",true);
	}
	
	@Test(dependsOnMethods ="createAdminTest",groups = "RegressionTest")
	public void deleteOrderTest()
	{
		Reporter.log("Admin deleted successfully",true);
	}

}
