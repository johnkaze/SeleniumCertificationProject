package pages;

import objectrepository.ObjectRepository;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Constants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import util.SeleniumUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class WalmartPhoneOrderPage {
    private WebDriver driver;
    private Properties properties;
    private SeleniumUtils seleniumUtils;
	WebDriverWait wait;
	List<WebElement> links = null;
	List<WebElement> anchors = null;
	String phonedescriptionList = null;
	String phonedescriptionCart = null;
	
	Select stateSelect = null;
	boolean status1;

    public WalmartPhoneOrderPage(WebDriver driver, Properties properties, SeleniumUtils seleniumUtils) {
        this.driver = driver;
        this.properties = properties;
        this.seleniumUtils = seleniumUtils;
        wait=new WebDriverWait(driver, 5);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), new ObjectRepository());

    }
    
    public void walmartLogin() {
    	XSSFWorkbook wb = null;
//    	FileInputStream inFile = null;
    	XSSFSheet sheet = null;
    	XSSFRow row = null;
    	XSSFCell cell0 = null;
    	XSSFCell cell1 = null;
    	String userName = null;
    	String passWord = null;
    	DataFormatter dataFormatter = new DataFormatter();
//
//	Login into the Walmart URL www.walmart.com.   	
//
//	Note: The Walmart site uses a demanding Captcha test when
//    	logging in from automation code. You will need to stop execution
//    	with a break point following the logInButton click line of code.
//    	
    	try {
			wb = (XSSFWorkbook) XSSFWorkbookFactory.createWorkbook(new File(Constants.XLSX_INPUT_DIR + Constants.USERNAME_PASSWORD_XLSX), true);
			sheet = wb.getSheetAt(0);
			row = sheet.getRow(1);
			cell0 = row.getCell(0);
			cell1 = row.getCell(1);
			userName = dataFormatter.formatCellValue(cell0);
			passWord = dataFormatter.formatCellValue(cell1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.accountDropDown));
    	ObjectRepository.accountDropDown.click();
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.signIn));
    	ObjectRepository.signIn.click();
    	ObjectRepository.userId.clear();
//    	ObjectRepository.userId.sendKeys(properties.getProperty("UserID"));
    	ObjectRepository.userId.sendKeys(userName);
    	ObjectRepository.passWord.clear();
//    	ObjectRepository.userId.sendKeys(properties.getProperty("UserPW"));
    	ObjectRepository.passWord.sendKeys(passWord);
    	
    	ObjectRepository.logInButton.click();
//
//  Place the Login break point on the following line of code to stop for Captcha interruption:    	
//             	
        seleniumUtils.waitForPageLoad(driver, 500);

//
// 	Validate login 
//        	

    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.accountDropDown));
    	ObjectRepository.accountDropDown.click();
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.accountProfile)); 
    	ObjectRepository.accountProfile.click();
        seleniumUtils.waitForPageLoad(driver, 500);
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.accountEmailOption)); 
    	ObjectRepository.accountEmailOption.click();
        seleniumUtils.waitForPageLoad(driver, 500);   	
        Assert.assertEquals(properties.getProperty("UserID"),ObjectRepository.accountEmail.getText());
    }
    public void walmartPhonesLoad() {
//
//     	Load the products display page with all of the iPhone 6s plus    	
//    	mobile phones in the $150 - $200 range.
//        	
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.searchDropdown));
		ObjectRepository.searchDropdown.click();
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.cellPhones));
		ObjectRepository.cellPhones.click();
		ObjectRepository.searchInput.sendKeys("iPhone 6s plus");
		ObjectRepository.searchSubmit.click();
    	seleniumUtils.waitForPageLoad(driver, 1000);

//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.dollarRange));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.dollarRange);
		System.out.println("dollarRange " + status1);
    	ObjectRepository.dollarRange.click();
    	seleniumUtils.waitForPageLoad(driver, 1000);
		
//
//	 	Add the second iPhone 6s plus displayed to the shopping cart after 	
//		selecting the gray color.
//
		
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.firstIphone6s));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.firstIphone6s);
		System.out.println("firstIphone6s " + status1);
    	links = ObjectRepository.unorderedList.findElements(By.tagName("li"));
		anchors = links.get(1).findElements(By.tagName("a"));
		phonedescriptionList = anchors.get(1).getAttribute("title");
    	ObjectRepository.firstIphone6s.click();
    	seleniumUtils.waitForPageLoad(driver, 1000);

//		Actions builder = new Actions(driver);
//		builder.moveToElement(ObjectRepository.darkButton).build().perform();
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.colorButton));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.colorButton);
		System.out.println("colorButton " + status1);    	
    	ObjectRepository.colorButton.click();
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.addToCart);
		System.out.println("addToCart " + status1);  
    	ObjectRepository.addToCart.click();
    	
    	seleniumUtils.waitForPageLoad(driver, 500);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.checkoutButton));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.checkoutButton);
		System.out.println("checkoutButton " + status1);   
    	phonedescriptionCart = ObjectRepository.cartDescription.getText();
 
//
//	 	Validate that the phone was added to the cart.
//
    	
        Assert.assertEquals(phonedescriptionList,phonedescriptionCart);
        ObjectRepository.checkoutButton.click();
        
//
//	 	Place a break point on the following line of code to stop execution in order to handle 	
//		a possible (not always required) manual re-entry of the password.
//
        
    	seleniumUtils.waitForPageLoad(driver, 500);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.continueButton1));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.continueButton1);
		System.out.println("continueButton1 " + status1);   
    	ObjectRepository.continueButton1.click();
    	
//    	seleniumUtils.waitForPageLoad(driver, 1000);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.continueButton1));
//    	ObjectRepository.continueButton1.click();    	
    	
//
//	 	Add a new shipping address before proceeding with checkout. 	
//
    	
    	seleniumUtils.waitForPageLoad(driver, 500);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.addNewAddress));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.addNewAddress);
		System.out.println("addNewAddress " + status1);  
    	ObjectRepository.addNewAddress.click();
    	seleniumUtils.waitForPageLoad(driver, 500);
    	
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.firstName));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.firstName);
		System.out.println("firstName " + status1);  
    	ObjectRepository.firstName.clear();
    	ObjectRepository.firstName.sendKeys("Don");
    	ObjectRepository.lastName.clear();
    	ObjectRepository.lastName.sendKeys("Burroughs");
    	ObjectRepository.phoneNumber.clear();
    	ObjectRepository.phoneNumber.sendKeys("(215) 483-1796");
    	ObjectRepository.streetAddress.clear();
    	ObjectRepository.streetAddress.sendKeys("574 Rector Street");
    	ObjectRepository.aptNumber.clear();
    	ObjectRepository.cityName.clear();
    	ObjectRepository.cityName.sendKeys("Philadelphia");
    	stateSelect = new Select(ObjectRepository.stateID);
    	stateSelect.selectByVisibleText("Pennsylvania");
    	ObjectRepository.zipCode.clear();
    	ObjectRepository.zipCode.sendKeys("19128");
    	ObjectRepository.saveAddress.click();
    	seleniumUtils.waitForPageLoad(driver, 1000);
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.continueButton2);
		System.out.println("continueButton2 " + status1);  
    	ObjectRepository.continueButton2.click();
    	
//
//	 	Validate the new shipping address and logout (logout executed by calling method) without
//		entering credit card details.
// 

    	seleniumUtils.waitForPageLoad(driver, 7000);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.shoppingCart));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.shoppingCart);
		System.out.println("shoppingCart " + status1);  
    	
        Assert.assertEquals("Don Burroughs",ObjectRepository.shippingName.getText());
        Assert.assertEquals("574 Rector Street",ObjectRepository.shippingStreet.getText());
        Assert.assertEquals("Philadelphia, PA 19128",ObjectRepository.shippingCityStateZip.getText());

    	ObjectRepository.shoppingCart.click();
    	seleniumUtils.waitForPageLoad(driver, 500);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.accountDropDown));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.accountDropDown);
		System.out.println("accountDropDown " + status1); 
    	ObjectRepository.accountDropDown.click();
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.signOut));
    }
    public String getSignOFF(){
        return ObjectRepository.signOut.getText();
    }

    public  void walmartLogouout() {
    	ObjectRepository.signOut.click();
    }

}
