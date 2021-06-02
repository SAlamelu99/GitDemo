package OutdoorToysSearch.com;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ToysSearchforNewDOM extends Base {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		Base b = new Base();
		
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
		List<WebElement> links = driver.findElements(By.xpath("//a/h3"));
		
		//verify the link contains Portable
		for(WebElement link : links) {
			
	        if(link.getText().contains("Portable")) {
	        	
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
