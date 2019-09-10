package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.Select;

public class ObjectRepository {

//	@FindBy(xpath = "//span[@class='e_a y_c y_f e_g e_b e_p v_a v_h v_j'][contains(text(),'Account')]")
	@FindBy(xpath = "//button[@id='header-account-toggle']")
	public static WebElement accountDropDown;

	@FindBy(xpath = "//div[contains(text(),'Sign In')]")
	public static WebElement signIn;

	@FindBy(xpath = "//input[@id='email']")
	public static WebElement userId;

	@FindBy(xpath = "//input[@id='password']")
	public static WebElement passWord;

	@FindBy(xpath = "//button[@class='button m-margin-top'][contains(text(),'Sign In')]")
	public static WebElement logInButton;

	@FindBy(xpath = "//div[@class='variant-options-container']//span[2]")	
//	@FindBy(xpath = "div.js-content:nth-child(1) div.page-wrapper div.page-full-wrapper div.js-body-content:nth-child(2) div.ProductPage-verticalTheme-standard.ProductPage-verticalId-standard.feature-productHighlights div.atf-content div.ProductPage-verticalTheme-standard.ProductPage-verticalId-standard.feature-productHighlights div.atf-content div.ResponsiveContainer.ny-atf-container.mweb-enhanced-atf div.Grid div.Grid:nth-child(4) div.Grid-col.u-size-1-2-m:nth-child(2) div.hf-Bot.hf-PositionedRelative div.hf-BOTContainer.bot-atc-so-po-layout.bot-enhanced-mweb div.prod-VariantsSection.hf-BotRow:nth-child(6) div.variants-category-wrapper div.variant-category-container div.variants-container.variant-swatches-outer-wrapper div.variant-options-container span.variant-option-outer-container.display-inline-block.valign-top:nth-child(2) > div.variant-option-inner-container")
//	@FindBy(css = "div.js-content:nth-child(1) div.page-wrapper div.page-full-wrapper div.js-body-content:nth-child(2) div.ProductPage-verticalTheme-standard.ProductPage-verticalId-standard.feature-productHighlights div.atf-content div.ProductPage-verticalTheme-standard.ProductPage-verticalId-standard.feature-productHighlights div.atf-content div.ResponsiveContainer.ny-atf-container.mweb-enhanced-atf div.Grid div.Grid:nth-child(4) div.Grid-col.u-size-1-2-m:nth-child(2) div.hf-Bot.hf-PositionedRelative div.hf-BOTContainer.bot-so-atc-po-layout.bot-enhanced-mweb div.prod-VariantsSection.hf-BotRow:nth-child(6) div.variants-category-wrapper div.variant-category-container div.variants-container.variant-swatches-outer-wrapper div.variant-options-container span.variant-option-outer-container.display-inline-block.valign-top:nth-child(2) div.variant-option-inner-container > div.option-overlay")
	public static WebElement colorButton;

	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	public static WebElement addToCart;
	
	@FindBy(xpath = "//button[@class='button ios-primary-btn-touch-fix hide-content-max-m checkoutBtn button--primary']//span[@class='button-wrapper'][contains(text(),'Check Out')]")
	public static WebElement checkoutButton;
	
	@FindBy(xpath = "//span[contains(text(),'Continue')]")
	public static WebElement continueButton1;
	
	@FindBy(xpath = "//span[@class='elc-icon elc-icon-add elc-icon-18 valign-middle']")
	public static WebElement addNewAddress;
	
	@FindBy(xpath = "//input[@id='firstName']")
	public static WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	public static WebElement lastName;
	
	@FindBy(xpath = "//input[@id='phone']")
	public static WebElement phoneNumber;
	
	@FindBy(xpath = "//input[@id='addressLineOne']")
	public static WebElement streetAddress;
	
	@FindBy(xpath = "//input[@id='addressLineTwo']")
	public static WebElement aptNumber;
	
	@FindBy(xpath = "//input[@id='city']")
	public static WebElement cityName;
	
	@FindBy(xpath = "//select[@id='state']")
	public static WebElement stateID;	
	
	@FindBy(xpath = "//input[@id='postalCode']")
	public static WebElement zipCode;
	
	@FindBy(xpath = "//span[contains(text(),'Save Address')]")
	public static WebElement saveAddress;
	
	@FindBy(xpath = "//span[contains(text(),'Continue')]")
	public static WebElement continueButton2;
	
	@FindBy(css = "div.js-content:nth-child(1) div.use-new-orange div.checkout-wrapper:nth-child(1) div.accordion-outer-wrapper div.accordion-inner-wrapper div.pos-relative.checkout-header.checkout-header-ny.access-header-container div.checkout-responsive-container.ResponsiveContainer div.text-left.Grid div.Grid-col.u-size-4-12:nth-child(3) div.checkout-header-cart-ny a.pull-right > span.elc-icon.elc-icon-cart.elc-icon-16")
	public static WebElement shoppingCart;
	
	@FindBy(xpath = "//div[contains(text(),'Sign Out')]")
	public static WebElement signOut;

	@FindBy(xpath = "//button[@id='global-search-dropdown-toggle']//span[@class='g_a g_f']")
	public static WebElement searchDropdown;

	@FindBy(xpath = "//div[@id='SearchDropdown-list']//div[1]//button[6]")
	public static WebElement cellPhones;

	@FindBy(xpath = "//input[@id='global-search-input']")
	public static WebElement searchInput;

	@FindBy(xpath = "//button[@id='global-search-submit']//span[@class='g_a g_f']")
	public static WebElement searchSubmit;
	
	@FindBy(xpath = "//span[contains(text(),'$150 - $200')]")
	public static WebElement dollarRange;

	@FindBy(xpath = "//li[2]//div[1]//div[2]//div[5]//div[1]//a[1]")
//	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[5]/div[1]/a[1]/span[1]")
	public static WebElement firstIphone6s;

	@FindBy(xpath = "//ul[@class='paginator-list']")
	public static WebElement unorderedPages;

	@FindBy(xpath = "//ul[@class='search-result-gridview-items four-items']")
	public static WebElement unorderedList;

	@FindBy(xpath = "//button[@class='elc-icon paginator-hairline-btn paginator-btn paginator-btn-next outline']")
	public static WebElement nextPage;
	
	@FindBy(xpath = "//a[@class='js-btn-product btn-fake-link cart-item-name-link']")
	public static WebElement cartDescription;
	
	@FindBy(xpath = "//span[@class='shipping-address-long-word']")
	public static WebElement shippingName;	

	@FindBy(xpath = "//div[@class='font-semibold']//span[contains(text(),'574 Rector Street')]")
	public static WebElement shippingStreet;
	
	@FindBy(xpath = "//div[@class='CXO_module_header normal ResponsiveContainer']//span[3]")
	public static WebElement shippingCityStateZip;
	
	@FindBy(xpath = "//p[contains(text(),'jkaze@si.rr.com')]")
	public static WebElement signonEmail;
	
	@FindBy(xpath = "//div[contains(text(),'Account')]")
	public static WebElement accountProfile;	

	@FindBy(xpath = "//a[contains(text(),'Profile & Password')]")
	public static WebElement accountEmailOption;	
	
	@FindBy(xpath = "//p[contains(text(),'jkaze@si.rr.com')]")
	public static WebElement accountEmail;	

	
	
//  ************************	
	
	@FindBy(xpath = "//div[@class='search-result-listview-items']")
	public static WebElement listView;	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
