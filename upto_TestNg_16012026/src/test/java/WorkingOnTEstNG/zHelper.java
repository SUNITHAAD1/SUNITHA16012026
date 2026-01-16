package WorkingOnTEstNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;
import com.Comcast.Crm.BaseClass.Configuration_BaseClass;

public class zHelper extends Configuration_BaseClass
{
	@Test (groups="SmokeTest")
	public void createHelper()
	{
		Reporter.log("Helper created successfully",true);
	}
	
	@Test(groups = "RegressionTest")
	public void modifyHelper()
	{
		Reporter.log("Helper modified successfully",true);
	}
	@Test(groups = "RegressionTest")
	public void deleteHelper()
	{
		Reporter.log("Helper deleted successfully",true);
	}


}
