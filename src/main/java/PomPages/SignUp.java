package PomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {

	@FindBy(id="First Name")
	private WebElement firstname;
	@FindBy(id="Last Name")
	private WebElement lastname;
	@FindBy(xpath="//div[@id='Gender']/descendant::label/span[2]")
	private List<WebElement> genderRadioButton;
	@FindBy(id="Phone Number")
	private WebElement phonenumber;
	@FindBy(id="Email Address")
	private WebElement emailAddress;
	@FindBy(id="Password")
	private WebElement password;
	@FindBy(id="Confirm Password")
	private WebElement confirmpassword;
	@FindBy(id="Terms and Conditions")
	private WebElement termsandconditionsCB;
	@FindBy(xpath = "//button[text()='Register']")
	private WebElement registerButton;
	
	public  SignUp(WebDriver driver) {
	
	
	}
	
		//Initialization
		public void  SignUpPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
		//Utilization
		public void createUserAccount(String firstName,String lastName,String expectedGender, String phoneNumber, String email, String Password) {
			firstname.sendKeys(firstName);
			lastname.sendKeys(lastName);
			
			for(WebElement element: genderRadioButton) {
				String gender = element.getText();
				if(gender.equals(expectedGender)) {
					element.click();
					break;
				}
			
				}
		
			phonenumber.sendKeys(phoneNumber);
			emailAddress.sendKeys(email);
			password.sendKeys(Password);
			confirmpassword.sendKeys(Password);
			termsandconditionsCB.click();
			try {
				Thread.sleep(3000);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
			
			registerButton.click();
			}
		

}
