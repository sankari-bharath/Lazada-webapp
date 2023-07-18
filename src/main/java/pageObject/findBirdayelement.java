package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class findBirdayelement {
	
	WebDriver ldriver;

	public findBirdayelement(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//li[@id='My-profile']/a")
	WebElement myprofile;
	
	@FindBy(xpath = "//*[@class='my-profile-item-info']")
	WebElement birthday;
	
	

public void profile() {
		
	myprofile.click();
	}

	public void birthday() {
		
		birthday.getText();
	}
}