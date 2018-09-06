
package de.mb.selenium;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStartPageTest {

	private WebDriver driver;
	
	
	@Before
	public void setUp() throws MalformedURLException {
		String serverUrl = System.getProperty("grid.server.url");		
		String gridServerUrl = "http://seleniumhub:4444/wd/hub";
		if (serverUrl != null) {
			gridServerUrl = serverUrl;
		}
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		URL gridUrl = new URL(gridServerUrl);
		driver = new RemoteWebDriver(gridUrl, capability);
		driver.get("https://samplep2000474034trial.hanatrial.ondemand.com/explore-ui5/");
	}
	@After
	public void tearDownWebDriver() {
		driver.quit();
	}


	@Test
	public void pageBodyIsNotNull() throws MalformedURLException {
		
	
		System.out.println("1. Executing Body Test");
		String bodyText = driver.findElement(By.tagName("body")).getText();
		assertTrue(bodyText != null);
		 try {
           		 wait(500000);
        	} catch (Exception e) {}
				
	}

	@Test
	public void textBoxuiAreaMatch() throws MalformedURLException {

		 
		System.out.println("2. Executing Body Text Match Test");
		String testTextField = driver.findElement(By.id("testTextField")).getText();
		WebElement textField = driver.findElement(By.id("testTextField"));
		textField.sendKeys("shree-sap-java-web");
		String testLabel = driver.findElement(By.id("testLabel")).getText();
		System.out.println(testLabel);
		 try {
           		 wait(500000);
        	} catch (Exception e) {}
		
		assertTrue(testTextField!=testLabel);	
	}
	
	@Test
	public void textBoxuiAreaPopUp() throws MalformedURLException {
		
		
		System.out.println("3. Executing Pop up test");
		WebElement button = driver.findElement(By.id("testButton"));
		button.click();
		WebElement okButton = driver.findElement(By.xpath("//*[contains(@id,'--btn-OK')]"));
		String okButtonText = okButton.getText();
		System.out.println(okButtonText);
		 try {
           		 wait(500000);
        	} catch (Exception e) {}
		//TimeUnit.SECONDS.sleep(1);
	}
	
}
