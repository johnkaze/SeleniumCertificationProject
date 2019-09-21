package automation;

import base.TestBase;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.WalmartPhoneOrderPage;

public class WalmartPhoneOrderTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(WalmartPhoneOrderTest.class);// Using slf4j

    @Test(priority = 1)
    public void walmartPhoneOrderTest() {
        Reporter.log("", true);
        Reporter.log("*** Start of Walmart Phone Order ***", true);
        Reporter.log("", true);

        WalmartPhoneOrderPage walmartPhoneOrderPage = new WalmartPhoneOrderPage(driver, properties, seleniumUtils);

//        String url = "http://www.walmart.com/";//properties.getProperty(PropertyConstants.URL);
        String url = properties.getProperty("URL");

        seleniumUtils.getUrl(url);
        seleniumUtils.waitForPageLoad(driver, 1000);

        walmartPhoneOrderPage.walmartLogin();;
        
        walmartPhoneOrderPage.walmartPhonesLoad();;

        String signOFF = walmartPhoneOrderPage.getSignOFF();
        logger.info("SignOff text from appln is :: " + signOFF);
        Assert.assertEquals(signOFF,"Sign Out");

        walmartPhoneOrderPage.walmartLogouout();

        Reporter.log("", true);
        Reporter.log("*** End of Walmart Phone Order ***", true);
        Reporter.log("", true);

    }

}
