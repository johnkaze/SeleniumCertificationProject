package pages;

import base.Constants;
import objectrepository.ObjectRepository;

import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import util.SeleniumUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class WalmartMobilePhonesPage {

    private WebDriver driver;
    private Properties properties;
    private SeleniumUtils seleniumUtils;
    

    public WalmartMobilePhonesPage(WebDriver driver, Properties properties, SeleniumUtils seleniumUtils) {
        this.driver = driver;
        this.properties = properties;
        this.seleniumUtils = seleniumUtils;
//        PageFactory.initElements(driver, this);
//    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), new ObjectRepository());
//      PageFactory.initElements(driver, new ObjectRepository());

    }
    
    public int loadMobilePhones() {
    	
    	WebElement pricecurrency = null;
    	WebElement pricecharacteristic = null;
    	WebElement pricemark = null;
    	WebElement pricemantissa = null;
//    	List<WebElement> pages = null;
    	List<WebElement> listViewItems = null;
    	List<WebElement> anchors = null;
    	String phonedescription = null;
    	String phoneprice = null; 
    	boolean notEof = true;
    	int lastRow = 1;

    	XSSFWorkbook wb = null;
    	FileOutputStream out = null;
    	XSSFSheet sheet = null;
    	XSSFRow row = null;
    	XSSFCell cell0 = null;
    	XSSFCell cell1 = null;
    	XSSFCellStyle cellStyle = null;
    	WebDriverWait wait;
    	
    	boolean status1;
    	
//
//    	Delete old Excel spreadsheet & create a new replacement spreadsheet that will be loaded    	
//		with all the mobile phones from the walmart site
//        	    	
    	
    	try{ 
    		Files.deleteIfExists(Paths.get(Constants.XLSX_DIR + Constants.MOBILE_PHONE_XLSX)); 
    	} 
    	catch(NoSuchFileException e){ 
//    		System.out.println("No such file/directory exists"); 
    		Reporter.log("No such file/directory exists", true);
    	} 
    	catch(DirectoryNotEmptyException e){ 
//    		System.out.println("Directory is not empty.");
    		Reporter.log("Directory is not empty", true);
    	} 
    	catch(IOException e){ 
//    		System.out.println("Invalid permissions.");
    		Reporter.log("Invalid permissions", true);
    	} 
//    	System.out.println("Excel File Deletion Successful.");
		Reporter.log("Excel File Deletion Successful", true);

		wb = new XSSFWorkbook();
		sheet = wb.createSheet();
		row = sheet.createRow(0);
		cell0 = row.createCell(0);
   		cell1 = row.createCell(1);
		sheet.setColumnWidth(0, sheet.getColumnWidth(0) * 25);
		sheet.setColumnWidth(1, sheet.getColumnWidth(1) * 2);   		
   		cellStyle = wb.createCellStyle();
  		cellStyle.setVerticalAlignment(VerticalAlignment.TOP);
  		cellStyle.setWrapText(true);
  		cell0.setCellStyle(cellStyle);
  		cell1.setCellStyle(cellStyle);
  		cell0.setCellValue("Description");
  		cell1.setCellValue("Price");
    	try{
			out = new FileOutputStream(new File(Constants.XLSX_DIR + Constants.MOBILE_PHONE_XLSX));
    	}
    	catch(Exception e){
    		e.printStackTrace();
//    		System.out.println("Excel File Creation Failed.");
    		Reporter.log("Excel File Creation Failed", true);
    		}

//
//    	Load & iterate thru all of the mobile phone selection pages. For each phone displayed, write a
//		row into the newly created spreadsheet.
//
    	
    	wait=new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.searchDropdown));
		ObjectRepository.searchDropdown.click();
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.cellPhones));
		ObjectRepository.cellPhones.click();
		ObjectRepository.searchInput.sendKeys("Mobile Phone");
		ObjectRepository.searchSubmit.click();
        notEof = true;
    	while (notEof)
        {
        	seleniumUtils.waitForPageLoad(driver, 1500);
//        	pages = ObjectRepository.unorderedPages.findElements(By.tagName("a"));

//    		status1 = seleniumUtils.waitForElementClickable(driver, pages.get(0));
//    		System.out.println(status1);

        	listViewItems = ObjectRepository.listView.findElements(By.className("arrange"));

        	for (int i = 0; i < listViewItems.size(); i++)
        	{
        		try {
            		anchors = listViewItems.get(i).findElements(By.tagName("a"));
            		phonedescription = "";
            		for (int j = 1; j < anchors.size(); j++) {
            			phonedescription = anchors.get(j).getAttribute("title");
            			if (phonedescription.length() > 0) break;
        			// 	phonedescription = anchors.get(2).getText();
            		}

        		} catch (Exception e) {
        			phonedescription = "No Title";	
        		}
        		try {
            		pricecurrency = listViewItems.get(i).findElement(By.className("price-currency"));
            		pricecharacteristic = listViewItems.get(i).findElement(By.className("price-characteristic"));
            		pricemark = listViewItems.get(i).findElement(By.className("price-mark"));
            		pricemantissa = listViewItems.get(i).findElement(By.className("price-mantissa"));
            		phoneprice = pricecurrency.getText() + pricecharacteristic.getText() + pricemark.getText() + pricemantissa.getText();
        		} catch (Exception e) {
        			phoneprice = "No Price";
        		}
//        		System.out.println(phonedescription);
//        		System.out.println(phoneprice);
        		Reporter.log(phonedescription, true);
        		Reporter.log(phoneprice, true);

        		row = sheet.createRow(lastRow++);
        		cell0 = row.createCell(0);
           		cell1 = row.createCell(1);
          		cell0.setCellStyle(cellStyle);
          		cell1.setCellStyle(cellStyle);
          		cell0.setCellValue(phonedescription);
          		cell1.setCellValue(phoneprice);
        	}
        	try {
        		if (ObjectRepository.nextPage.isDisplayed()) {
        			ObjectRepository.nextPage.click();
        		} else {
        			notEof = false;
        		}
        	} catch (Exception e) {
        		notEof = false;
        	}
        }
    	
//
//		Write and close the Excel spreadsheet.
//
    	
    	try {
    		wb.write(out);
			if(out!=null)
				out.close();
			if(wb!=null)
				wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return (lastRow - 1);

    }


}
