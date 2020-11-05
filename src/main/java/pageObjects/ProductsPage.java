package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import E2E.Appium_Framework.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {
	private final AndroidDriver<AndroidElement> driver;
	private final Utilities utilities;
	public ProductsPage(AndroidDriver<AndroidElement> driver) {
		utilities=new Utilities(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	private List<WebElement> productNames;	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCartButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartIcon;
	
	public void addProductsToCart() {
		 //Scrolling to click a specific product/s
	    utilities.scrollInToView("Jordan 6 Rings");

	     int count= productNames.size();

	   for(int i=0;i<count;i++)
	   {
	         String text=productNames.get(i).getText();

	         if(text.equalsIgnoreCase("Jordan 6 Rings"))

	         {
	        	 addToCartButton.get(0).click();
	        	 addToCartButton.get(1).click();
	        	 break;
	         }
        }
	}
	
	public void viewCart() {
		cartIcon.click();
	}

}
