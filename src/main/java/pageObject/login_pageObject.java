package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_pageObject {

	WebDriver ldriver;

	public login_pageObject(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	WebElement user_id;
	@FindBy(xpath = "//*[@type='password']")
	WebElement pswd;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	


	public void userid(String userid) {
		
		user_id.sendKeys(userid);
	}

	public void password(String password) {
		pswd.sendKeys(password);
	}

	public void loginn() {
		submit.click();
	}
	
}
