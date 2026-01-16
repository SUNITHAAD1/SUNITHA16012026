package WorkingOnTEstNG;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ConfigurationAnnotation;

import com.Comcast.Crm.BaseClass.ConfigurationAnnotations_BaseClass;

public class CustomerOrderTest extends ConfigurationAnnotation {

	@Test (groups="SmokeTest")
	public void createOrderTest()
	{
		Reporter.log("customer order created successfully",true);
	}
	
	@Test(dependsOnMethods ="createOrderTest" )
	public void modifyOrderTest()
	{
		Reporter.log("customer order modified successfully",true);
	}
	
	@Test(dependsOnMethods ="createOrderTest", enabled = true)
	public void deleteOrderTest()
	{
		Reporter.log("customer order deleted successfully",true);
	}
	
}
