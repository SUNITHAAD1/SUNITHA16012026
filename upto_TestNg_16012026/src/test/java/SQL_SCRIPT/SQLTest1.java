package SQL_SCRIPT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SQLTest1 {
public static void main(String[] args) throws SQLException {
	
	
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218::3307/ninza_hrm_sunitha","root@%","root");
	Statement stat = conn.createStatement();
	
	boolean res = stat.execute("create table sunitha49(Name varchar(25),salary numeric(5),id numeric(5));");
	System.out.println("***");
	
	stat.execute("Insert into sunitha49 values(Suni,9999,10);");
	stat.execute("Insert into sunitha49 values(Mani,8888,20);");
	stat.execute("Insert into sunitha49 values(Soni,7777,30);");
	stat.execute("Insert into sunitha49 values(Rani,6666,40);");
	System.out.println("***");
	
}
}
