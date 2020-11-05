package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import E2E.Appium_Framework.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homepage {
	private final AndroidDriver<AndroidElement> driver;
	private final Utilities utilities;
	public Homepage(AndroidDriver<AndroidElement> driver) {
		utilities=new Utilities(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	private WebElement femaleRadioButtonOption;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countryDropdownMenu;
	
	@AndroidFindBy(xpath="//*[@text='Austria']")
	private WebElement austriaOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButton;
	
	public void captureName(String name) {
		nameField.sendKeys(name);
	    driver.hideKeyboard();
	}
	
	public void selectFemaleOption() {
		femaleRadioButtonOption.click();
	}
	
	public void selectCountry() {
		countryDropdownMenu.click();
		utilities.scrollToView("Austria");
		austriaOption.click();
	}
	
	public void startShopping() {
		letsShopButton.click();
	}

}
