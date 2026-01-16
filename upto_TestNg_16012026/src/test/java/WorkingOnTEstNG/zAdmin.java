package WorkingOnTEstNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;
import com.Comcast.Crm.BaseClass.Configuration_BaseClass;

public class zAdmin extends Configuration_BaseClass{
	@Test (groups="SmokeTest")
	public void AdmincreateTest()
	{
		Reporter.log("Admin  created successfully",true);
	}
	
	@Test(groups = "RegressionTest")
	public void AdminmodifyTest()
	{
		Reporter.log("Admin  modified successfully",true);
	}
	@Test(groups = "RegressionTest")
	public void AdmindeleteTest()
	{
		Reporter.log("Admin  deleted successfully",true);
	}

}
