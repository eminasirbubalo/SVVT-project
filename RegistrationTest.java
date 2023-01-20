package svvtprojekat;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class RegistrationTest {

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
		//webDriver.quit();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[1]/div[4]/header/nav/div/div[4]/button")).click();
		Thread.sleep(2000);
		
		//assertEquals("https://www.hotels.com/login",webDriver.getCurrentUrl());
		webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[1]/div[4]/header/nav/div/div[4]/div/div[1]/div/div/a[2]")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.name("signupFormEmailInput")).sendKeys("kerim.ahmedspahic@stu.ibu.edu.ba");
		webDriver.findElement(By.name("firstNameSignUp")).sendKeys("Kerim");
		webDriver.findElement(By.name("lastNameSignUp")).sendKeys("Ahmedspahic");
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[2]/div[4]/input")).sendKeys("MakEminaKerim1#");
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[2]/div[7]/div/input")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[2]/button")).click();
	}

}
