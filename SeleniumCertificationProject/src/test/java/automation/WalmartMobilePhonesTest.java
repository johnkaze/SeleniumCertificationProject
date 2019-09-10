package automation;

import base.TestBase;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.WalmartMobilePhonesPage;

public class WalmartMobilePhonesTest extends TestBase {

//    private static final Logger logger = LoggerFactory.getLogger(WalmartMobilePhonesTest.class);// Using slf4j

    @Test(priority = 1)
    public void walmartMobilePhonesTest() {
    	int loadedPhones;
        Reporter.log("", true);
        Reporter.log("*** Start of Mobile Phones Load ***", true);
        Reporter.log("", true);

        WalmartMobilePhonesPage walmartMobilePhonesPage = new WalmartMobilePhonesPage(driver, properties, seleniumUtils);

//        String url = "http://www.walmart.com/";//properties.getProperty(PropertyConstants.URL);
        String url = properties.getProperty("URL");

        seleniumUtils.getUrl(url);
        seleniumUtils.waitForPageLoad(driver, 1000);
        loadedPhones = walmartMobilePhonesPage.loadMobilePhones();

        Reporter.log("", true);
        Reporter.log("    Loaded Phones = " + loadedPhones, true);
        Reporter.log("*** End of Mobile Phones Load   ***", true);
        Reporter.log("", true);

    }



}
