package POM_IMPLEMENTATION;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
@FindBy(name="user_name")
private String unTBX;

@FindBy(name="user_password")
private WebElement pwdTBX;

@FindBy(name="//input[@id='submitButton']")
private WebElement loginBtn;

public LoginPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}

public void setUnTBX(String unTBX) {
	this.unTBX = unTBX;
}

public void setPwdTBX(WebElement pwdTBX) {
	this.pwdTBX = pwdTBX;
}

public void setLoginBtn(WebElement loginBtn) {
	this.loginBtn = loginBtn;
}

}
