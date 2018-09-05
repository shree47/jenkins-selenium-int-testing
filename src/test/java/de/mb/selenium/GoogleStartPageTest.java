

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
		String serverUrl = System.getProperty("grid.server.url");		String gridServerUrl = "http://seleniumhub:4444/wd/hub";
		if (serverUrl != null) {
			gridServerUrl = serverUrl;
		}
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		URL gridUrl = new URL(gridServerUrl);
		driver = new RemoteWebDriver(gridUrl, capability);
		driver.get("https://samplep20
			   
			   00474034trial.hanatrial.ondemand.com/explore-ui5/");
	}

	@After
	public void tearDownWebDriver() {
		driver.quit();
	}


	@Test
	public void pageBodyIsNotNull() throws MalformedURLException {
		
		String bodyText = driver.findElement(By.tagName("body")).getText();
		assertTrue(bodyText != null);
				
	}

	@Test
	public void textBoxuiAreaMatch() throws MalformedURLException {

		String testTextField = driver.findElement(By.id("testTextField")).getText();;
		String testLabel = driver.findElement(By.id("testLabel")).getText();
		assertTrue(testTextField!=testLabel);	
	}
	
	@Test
	public void textBoxuiPopUp() throws MalformedURLException {
		@FindBy(id = "testTextField")
		private WebElement textField;

		@FindBy(id = "testButton")
		private WebElement button;

		@FindBy(id = "testLabel")
		private WebElement label;
		
		webDriver.get(applicationUrl + "/");
		PageFactory.initElements(webDriver, this);
		
		button.click();
		
	}	
	
}
