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

public class LoginTest {
	
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
	 void Login() throws InterruptedException {
	    webdriver.get(baseUrl);
	    webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[1]/div[4]/header/nav/div/div[4]/button")).click();
	    webdriver.findElement(By.cssSelector("#gc-custom-header-nav-bar-acct-menu > div > div.header-guest-heading > div > div > a.uitk-button.uitk-button-medium.uitk-button-fullWidth.uitk-button-has-text.uitk-button-primary")).click();
	    
	    WebElement email = webdriver.findElement(By.id("loginFormEmailInput"));
	    email.sendKeys("sirbubaloe@gmail.com");
	    WebElement password = webdriver.findElement(By.id("loginFormPasswordInput"));
	    password.sendKeys("Passw0rd123!");
	    
	    webdriver.findElement(By.id("loginFormSubmitButton")).click();
	   
	    Thread.sleep(5000);
	}

}

