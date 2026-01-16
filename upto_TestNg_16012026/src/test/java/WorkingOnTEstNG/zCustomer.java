package WorkingOnTEstNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;
import com.Comcast.Crm.BaseClass.Configuration_BaseClass;

public class zCustomer extends Configuration_BaseClass{
	@Test (groups="SmokeTest")
	public void createCustomerTest()
	{
		Reporter.log("Customer created successfully",true);
	}
	
	@Test(groups = "RegressionTest")
	public void modifyCustomerTest()
	{
		Reporter.log("Customer modified successfully",true);
	}
	@Test(groups = "RegressionTest")
	public void deleteCustomerTest()
	{
		Reporter.log("Customer deleted successfully",true);
	}

}
