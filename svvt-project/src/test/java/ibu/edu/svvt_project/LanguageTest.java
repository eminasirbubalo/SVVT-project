package ibu.edu.svvt_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LanguageTest {
	
	private static WebDriver webdriver;
	private static String baseUrl;
	
	@BeforeAll
	  static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\cutec\\Desktop/chromedriver.exe");
		webdriver = new ChromeDriver();
		baseUrl = "https://www.hotels.com/";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
	  }
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webdriver.quit();
	}
	
	@Test
	 void Language() throws InterruptedException {
		webdriver.get(baseUrl);
		webdriver.findElement(By.cssSelector("#secondaryNav > div > button")).click();
		
		Select region = new Select(webdriver.findElement(By.id("site-selector")));
	    region.selectByValue("300000014");
	    Thread.sleep(1000);
		Select language = new Select(webdriver.findElement(By.id("language-selector")));
	    language.selectByValue("de_CH");
	    webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[4]/button")).click();
		
		Thread.sleep(2000);
	}
	
}