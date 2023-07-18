package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class findBirdayelement {

	WebDriver ldriver;

	public findBirdayelement(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//li[@id='My-profile']/a")
	WebElement myprofile;

	@FindBy(xpath = "//*[@class='my-profile-item-info']")
	WebElement Xpath_birthday;

	@FindBy(css = "div:nth-child(4) > div.my-profile-item-info")
	WebElement CSS_birthday;

	public void profile() {

		myprofile.click();
	}

	public void xpath_birthday() {

		String BOD = Xpath_birthday.getText();
		System.out.println("BOD by Xpath" + BOD);
	}

	public void CSS_birthday() {

		String bod = CSS_birthday.getText();
		System.out.println("BOD by CSS " + bod);
	}
}