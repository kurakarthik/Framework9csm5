package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

	//Declaration
	@FindBy(xpath="//div[text()='My Addresses']")
private WebElement myAddressLink;
	
	//Initialization
	public MyProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public void clickMyAddress() {
		myAddressLink.click();
	}
}
