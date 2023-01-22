package svvtprojekat;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class HotelTest {

	private static WebDriver webDriver;
	private static String baseUrl;
	 private static WebDriverWait wait;
	


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		
		webDriver=new ChromeDriver(options);
		baseUrl="https://www.hotels.com/";
		
		wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
	       js.executeScript("window.scrollBy(0,550)", "");
		
		webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[8]/div/div/div/div/ul/li[4]/div/div/a")).click();
		webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/div[1]/div[4]/div[1]/div/div[1]/div[1]/ul/li[2]/div/div[2]/a")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section[1]/div/div/div/form/div/div[1]/div/div[1]/div/div/button[1]")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section[1]/div/div/div/form/div/div[1]/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr[5]/td[7]/button")).click();
		webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section[1]/div/div/div/form/div/div[1]/div/div[1]/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/button")).click();
		webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section[1]/div/div/div/form/div/div[1]/div/div[1]/div/div[2]/div/div[2]/div/button")).click();
		webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section[1]/div/div/div/form/div/div[3]/button")).click();
		Thread.sleep(5000);
		Select sort=new Select(webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/main/div/div/div/div/div[2]/section[2]/div/div[2]/div/div[2]/section/header/div/div[2]/div/form/div/div/select")));
		sort.selectByIndex(2);
		
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
