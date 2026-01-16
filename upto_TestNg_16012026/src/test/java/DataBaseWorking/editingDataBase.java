package DataBaseWorking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class editingDataBase {
public static void main(String[] args) throws SQLException {
	
	Driver driv=new Driver();
	DriverManager.registerDriver(driv);
	System.out.println("***************************************");
	Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm","root@%","root");
	Statement stat = conn.createStatement();
	
	  int insert1 = stat.executeUpdate("Insert into suni123 values(7,'Lisha',25000);");
	  int insert2 = stat.executeUpdate("Insert into suni123 values(8,'Misha',25000);");
	  int insert3 = stat.executeUpdate("Insert into suni123 values(9,'Nisha',25000);");
	  int insert4 = stat.executeUpdate("Insert into suni123 values(10,'Mishra',25000);");
	  int insert5 = stat.executeUpdate("Insert into suni123 values(11,'Pisha',25000);");

	  
	  ResultSet res = stat.executeQuery("select * from suni1234;");
	while(res.next())
	{
		System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3));	
	}
	
}
}
