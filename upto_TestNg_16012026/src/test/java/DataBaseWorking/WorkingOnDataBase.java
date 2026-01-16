package DataBaseWorking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class WorkingOnDataBase {
public static void main(String[] args) throws SQLException {
		Driver driv=new Driver();
		DriverManager.registerDriver(driv);
		System.out.println("***************************************");
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm","root@%","root");
		Statement stat = conn.createStatement();
		 ResultSet res = stat.executeQuery("select * from suni1234;");
		while(res.next())
		{
			System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3));	
		}
		 System.out.println("______________________________");
		System.out.println("-------- select query executed successfully-----------------");
	conn.close();
	
	
	}
}
