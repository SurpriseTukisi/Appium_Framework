package E2E.Appium_Framework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import E2E.Appium_Framework.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CartPage;
import pageObjects.Homepage;
import pageObjects.ProductsPage;

import java.io.IOException;

public class EcommerceE2E extends Base {
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}

	@Test(description = "As a user I want to register before I begin to shop")
	public void registerToShop() throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		service=startServer();
		AndroidDriver<AndroidElement> driver=capabilities("GeneralStoreApp");
		
		Homepage hp = new Homepage(driver);
	     
	     hp.captureName("Kagiso");	
	     hp.selectFemaleOption();
	     hp.selectCountry();	     
	     hp.startShopping();

	     //Validating the toast message
	    // String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
	     //System.out.println(toastMessage);
	     //Assert.assertEquals("Please enter your name", toastMessage);//Actual validation
	     // ===========================================================================================
	     
	    ProductsPage pp = new ProductsPage(driver);
	    pp.addProductsToCart();
	    pp.viewCart(); 

	    // String lastpageText=    driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

	    // Assert.assertEquals("Jordan 6 Rings", lastpageText);
	     
	        
	      // ===========================================================================================
	        
	        //validateTotalPurchaseAmount
	    CartPage cp = new CartPage(driver);
	    cp.validateTotalPurchaseAmount();

	        //Assert.assertEquals(sum, totalValue); 
	        
	        // =====================================================================================
	        
	      //Mobile Gestures
	    cp.completePurchase();
	    service.stop();
	          
	}

}
