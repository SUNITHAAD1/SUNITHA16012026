package WorkingOnTEstNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class workingOnDataProvider {

	@Test(dataProvider = "getData")
	public void dataProvierWork(String name,String place)
	{
		System.out.println("DATA PROVIDER OUTPUT");
		System.out.println("First Name    : "+name);
		System.out.println("Place    : "+place);
		System.out.println("********");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=  new Object[3][2];
					objArr[0][0]="Sunitha";
					objArr[0][1]="Bangalore";
					objArr[1][0]="Anitha";
					objArr[1][1]="Mangalore";
					objArr[2][0]="Vanitha";
					objArr[2][1]="Mandya";
					
		return objArr;
		
	}

}
