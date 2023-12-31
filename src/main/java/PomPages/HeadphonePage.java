package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeadphonePage {

	//Declaration
	@FindBy(xpath="//span[text()='boat rockerz 450']/ancestor::div[@class='featuredProducts_cardFooter__qL8vT']/descendant::button")
	private WebElement addToCartButton;
	@FindBy(xpath = "//span[text()='boat rockerz 450']")
	private WebElement itemName;
	@FindBy(id="cartIcon")
	private WebElement carticon;
	
	//Initialization
	public HeadphonePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public void clickAddToCart() {
		addToCartButton.click();
	}
	public String getAddToCartText() {
		return addToCartButton.getText();
	}
	public String getItemName() {
		return  itemName.getText();
	}
public void clickcarticon() {
	carticon.click();
}
}
