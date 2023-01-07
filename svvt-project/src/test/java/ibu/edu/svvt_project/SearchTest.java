package ibu.edu.svvt_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {
	
	private static WebDriver webdriver;
	private static String baseUrl;
    private static WebDriverWait wait;
	
	@BeforeAll
	  static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\cutec\\Desktop/chromedriver.exe");
		webdriver = new ChromeDriver();
		baseUrl = "https://www.hotels.com/";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		wait = new WebDriverWait(webdriver, Duration.ofSeconds(50));
	  }
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webdriver.quit();
	}
	
	@Test
	 void Search() throws InterruptedException {
		webdriver.get(baseUrl);
		webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section/form/div/div/div[1]/div/div/div/div[1]/div[1]/button")).click();
		WebElement goingTo = webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section/form/div/div/div[1]/div/div/div/div[2]/div[1]/div/input"));
	    goingTo.sendKeys("Zagreb");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" /html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section/form/div[2]/div/div[1]/div/div/div/div[2]/div[2]/ul/li[1]/button"))).click();
	    webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section/form/div/div/div[4]/button")).click();
	    try {
	        Thread.sleep(5000);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    WebElement city = webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/main/div/div/div/div/div[1]/section[1]/div/form/div[1]/div/div/div/div[1]/div[1]/button"));
	    assertEquals(city.getText(),"Zagreb, Croatia");
	}
	
}