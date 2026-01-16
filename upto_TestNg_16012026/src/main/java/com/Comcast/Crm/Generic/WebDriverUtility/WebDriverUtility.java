package com.Comcast.Crm.Generic.WebDriverUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void selectByIndex(WebElement driver, int index)
	{
		Select s=new Select(driver);
		s.selectByIndex(index);
	}
	public void selectByValue(WebElement driver, String value)
	{
		Select s=new Select(driver);
		s.selectByValue(value);
	}
	public void selectByVisibleText(WebElement driver, String text)
	{
		Select s=new Select(driver);
		s.selectByVisibleText(text);
	}
	public void selectByContainsVisibleText(WebElement driver, String vistext)
	{
		Select s=new Select(driver);
		s.selectByContainsVisibleText(vistext);
	}
	public void deselectByIndex(WebElement driver, int index)
	{
		Select s=new Select(driver);
		s.deselectByIndex(index);
	}
	public void deselectByValue(WebElement driver, String value)
	{
		Select s=new Select(driver);
		s.deselectByValue(value);
	}
	public void deselectByVisibleText(WebElement driver, String text)
	{
		Select s=new Select(driver);
		s.deselectByVisibleText(text);
	}
	public void deselectByContainsVisibleText(WebElement driver, String vistext)
	{
		Select s=new Select(driver);
		s.deSelectByContainsVisibleText(vistext);
	}
	public void deselectAll(WebElement driver)
	{
		Select s=new Select(driver);
		s.deselectAll();
	}
	
	public void doubleClick(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();	
	}
	public void rightClick(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.contextClick(ele).perform();
	}
	public void moveToElement(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();	
	}
	public void dragAndDrop(WebDriver driver,WebElement ele1,WebElement ele2)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(ele1,ele2).perform();	
	}
	public void click(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.click().perform();	
	}
	public void pageToLoad(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
