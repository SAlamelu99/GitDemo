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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
public static WebDriver driver;
	Changing the line
	public static void getWebDriver() {
		
		        //getting the user input for browser
				System.out.print("Which browser you want to execute \n 1. Chrome \n 2. MS Edge \n 3. Firefox \n Type the number: ");
				Scanner sc = new Scanner(System.in);
				int num = sc.nextInt();
				
				//Launching the Browser
				if(num == 1) {
				getChromeDriver();
				}
				else if(num==2) {
				getMSEdgeDriver();
				}
				else if(num==3) {
					getFirefoxDriver();
				}
				else {
					System.out.println("Invalid choice");
				}
				
	}
	
	public static void getChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\OutdoorToysSearch\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	public static void getFirefoxDriver() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\OutdoorToysSearch\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();  
	}
	
	public static void getMSEdgeDriver() {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\OutdoorToysSearch\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();  
		
	}
	
	
	public static void maximizeWindow() {
		
		driver.manage().window().maximize();
		
	}
	
	public static void loadUrl(String url) {
		
		driver.get(url);
		
	}
	
	public static void type(WebElement element, String data) {
		
		element.sendKeys(data);
		
	}
	
	public static void btnClick(WebElement element) {
		
		element.click();
		
	}
	
	public static List<WebElement> getAllLinks() {
		
		return driver.findElements(By.tagName("a"));
		
	}
	
	public static String getValueByAttribute(WebElement element, String value) {
		
		return element.getAttribute(value);
		
	}
	
    public static String getValueByText(WebElement element) {
		
		return element.getText();
		
	}
    
    public static String getPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public static void scrollJs(WebElement element) {
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",element);
		 
	}
	
	public static void clickJs(WebElement element) {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",element);
		
	}
	
	public static void takeScreenshot(String fileName) throws IOException {
		
		File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Lenovo\\eclipse-workspace\\OutdoorToysSearch\\Screenshot\\"+fileName+".png");
		FileUtils.copyFile(src,des);
		
	}
	
	public static void closeWebDriver() {
		
		driver.close();
		
	}
}
