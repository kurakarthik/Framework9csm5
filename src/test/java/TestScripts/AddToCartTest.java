package TestScripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class AddToCartTest extends BaseClass{
	@Test
	public void addAddressTest() throws InterruptedException{
		Map<String,String> map = excel.getData("Sheet1", "Add To Cart");
		welcome.clickLoginButton();
		login.loginToApp(map.get("Email"),map.get("Password"));
		Thread.sleep(2000);
		home.mouseHoverToElectronic(webUtil);
		Thread.sleep(3000);
		home.clickHeadPhonesLink();
		headPhone.clickAddToCart();
		Thread.sleep(3000);
		Assert.assertEquals(headPhone.getAddToCartText(), "ADDED");
		String itemName = headPhone.getItemName();
		headPhone.clickcarticon();
		Assert.assertTrue(cart.getCartItem().equalsIgnoreCase(itemName));
		
		
		
		
	}

	

}
