package SQL_SCRIPT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class SqlTestYanthraScript {
public static void main(String[] args) throws SQLException, InterruptedException {
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--disable-notifications");
	
	WebDriver driver=new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://49.249.28.218:8091/");
	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.linkText("Projects")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	driver.findElement(By.name("projectName")).sendKeys("SunithaProject1");
	driver.findElement(By.xpath("//label[text()='Project Manager*']")).sendKeys("RAM THE BOSS--");
	Select s=new Select(driver.findElement(By.name("status")));
	s.selectByValue("Created");
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	System.out.println(driver.switchTo().alert().getText());
	boolean flag=false;
	Driver dri=new Driver();
	DriverManager.registerDriver(dri);
	Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218::3333/ninza_hrm_sunitha","root@#","root");
	Statement stat = conn.createStatement();
	ResultSet result = stat.executeQuery("select * from project;");
	
	boolean res = stat.execute("create table sunitha49(Name varchar(25),salary numeric(5),id numeric(5));");
	System.out.println("***");
	
	stat.execute("Insert into sunitha49 values(Suni,9999,10);");
	stat.execute("Insert into sunitha49 values(Mani,8888,20);");
	stat.execute("Insert into sunitha49 values(Soni,7777,30);");
	stat.execute("Insert into sunitha49 values(Rani,6666,40);");

	System.out.println("***");
	
}
}
