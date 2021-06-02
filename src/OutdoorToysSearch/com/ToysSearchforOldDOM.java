package OutdoorToysSearch.com;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToysSearchforOldDOM extends Base{

	public static void main(String[] args) throws IOException, InterruptedException{
		
		Base b = new Base();
		
		//Invoking the Driver
		getWebDriver();
		
		//loading the url
		loadUrl("http://www.ebay.com");
		
		//maximizing the window
		maximizeWindow();
		
		//Locating the search box and type outdoor toys
		WebElement searchBox = driver.findElement(By.id("gh-ac"));
		type(searchBox,"outdoor toys");
		takeScreenshot("SearchBox");
		
		//Locating the search button and click it
		WebElement searchBtn = driver.findElement(By.id("gh-btn"));
		btnClick(searchBtn);
		
		//verifying the page Title
		System.out.print("The search result page title starts with outdoor toys: ");
		System.out.println(getPageTitle().startsWith("outdoor toys"));
		
		//Get all the links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//verify the href value contains Portable
		for(WebElement link : links) {
			
	        if(link.getAttribute("href").contains("Portable")) {
	        	scrollJs(link);
	            takeScreenshot("RequiredLink");
	            clickJs(link);
	            Thread.sleep(3000);
	            takeScreenshot("Output");
	            break;

	        }
		}
		
		//close the driver
		closeWebDriver();
		
	}

}
