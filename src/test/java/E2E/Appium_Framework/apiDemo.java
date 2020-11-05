package E2E.Appium_Framework;
import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import E2E.Appium_Framework.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class apiDemo extends Base{
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}

	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void basicTest(String name) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		service=startServer();
		AndroidDriver<AndroidElement> driver= capabilities("ApiDemoApp");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementById("android:id/edit").sendKeys(name);
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		service.stop();
		
	}

}
