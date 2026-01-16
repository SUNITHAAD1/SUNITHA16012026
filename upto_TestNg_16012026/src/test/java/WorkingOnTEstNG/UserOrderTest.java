package WorkingOnTEstNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;

public class UserOrderTest extends ConfigurationAnnotations_BaseClass
{
	@Test (invocationCount = 5,groups="SmokeTest")
	public void createUserOrderTest()
	{
		Reporter.log("User order created successfully",true);
	}
	
	@Test(dependsOnMethods ="createUserOrderTest" ,groups = "RegressionTest")
	public void modifyUserOrderTest()
	{
		Reporter.log("User order modified successfully",true);
	}
	
	@Test(dependsOnMethods ="createUserOrderTest")
	public void deleteUserOrderTest()
	{
		Reporter.log("User order deleted successfully",true);
	}

}
