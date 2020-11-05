package pageObjects;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
	private final AndroidDriver<AndroidElement> driver;
	public CartPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrices;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPurchaseAmount;
	
	@AndroidFindBy(className ="android.widget.CheckBox")
	private WebElement sendEmailCheckbox;
	
	@AndroidFindBy(xpath="//*[@text='Please read our terms of conditions']")
	private WebElement tcLongPressButton;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement closeTCs;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement completePurchaseButton;
	
	public void validateTotalPurchaseAmount() {
		//Verify that the total purchase amount is correct
        int count= productPrices.size();
        System.out.println("The size is "+count);
        double sum=0;

        for(int i=0;i<2;i++)
        {
        	String amount1= productPrices.get(i).getText();
        	double amount=getAmount(amount1);
        	sum=sum+amount;
        }
        System.out.println(sum+" Sum of products");

        String total=totalPurchaseAmount.getText();

        total= total.substring(1);

        double totalValue=Double.parseDouble(total);

        System.out.println(totalValue+" Total value of products");
	}
	
	public double getAmount(String value) {
		value = value.substring(1);

		double amount2value = Double.parseDouble(value);

		return amount2value;
	}
	
	public void completePurchase() {

        TouchAction t=new TouchAction(driver);

        t.tap(tapOptions().withElement(element(sendEmailCheckbox))).perform();

        t.longPress(longPressOptions().withElement(element(tcLongPressButton)).withDuration(ofSeconds(2))).release().perform();

        closeTCs.click();

        completePurchaseButton.click();   
	}

}
