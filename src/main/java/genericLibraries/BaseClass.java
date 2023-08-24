package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomPages.AddressFormPage;
import PomPages.CartPage;
import PomPages.HeadphonePage;
import PomPages.HomePage;
import PomPages.MyAddressPage;
import PomPages.MyProfilePage;
import PomPages.ShopperLoginPage;
import PomPages.SignUp;
import PomPages.WelcomePage;

public class BaseClass {
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	public WebDriver driver;
	public static WebDriver sdriver;
	
	protected WelcomePage welcome;
	protected ShopperLoginPage login;
	protected HomePage home;
	protected SignUp signUp;
	protected MyProfilePage myProfile;
	protected MyAddressPage myAddress;
	protected HeadphonePage headPhone;
	protected CartPage cart;
	protected AddressFormPage address;
	

	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classConfiguration() {
		property = new PropertiesUtility();
		excel  = new ExcelUtility();
		jutil = new JavaUtility();
		webUtil = new WebDriverUtility();
		
		property.propertiesInit(iConstantPath.PROPERTIES_PATH);
		excel.excelInit(iConstantPath.EXCEL_PATH);
	}
    @BeforeMethod
    public void methodConfiguration() {
    	driver = webUtil.navigateToApp(property.getData("browser"),property.getData("url"),Long.parseLong(property.getData("time")));
    	sdriver = driver;
    	welcome = new WelcomePage(driver);
    	login = new ShopperLoginPage(driver);
    	home = new HomePage(driver);
    	signUp = new SignUp(driver);
    	myProfile = new MyProfilePage(driver);
    	myAddress = new MyAddressPage(driver);
    	headPhone = new HeadphonePage(driver);
    	cart=new CartPage(driver);
    	address=new AddressFormPage(driver);
    }
    
    @AfterMethod 
    public void methodTeardown() {
    	home.clickProfileButton();
    	home.clickLogout();
    	webUtil.closeAllBrowser();
    }
    @AfterClass
    public void classTeardown() {
    	excel.closeExcel();
    }
    //@AfterTest
    //@AfterSuite
}
