package ibu.edu.svvt_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaveTripTest {
	
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
	 void saveATrip() throws InterruptedException {
		webdriver.get(baseUrl);
		JavascriptExecutor js = (JavascriptExecutor) webdriver;
		//login
	    webdriver.get(baseUrl);
	    webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[1]/div[4]/header/nav/div/div[4]/button")).click();
	    Thread.sleep(1000);
	    webdriver.findElement(By.linkText("Sign in")).click();
	    WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginFormEmailInput")));
	    email.sendKeys("sirbubaloe@gmail.com");
	    WebElement password = webdriver.findElement(By.id("loginFormPasswordInput"));
	    password.sendKeys("Passw0rd123!");
	    webdriver.findElement(By.id("loginFormSubmitButton")).click();
		Thread.sleep(5000);
		//save hotel to trips
		js.executeScript("window.scrollBy(0, 600)");
	    webdriver.findElement(By.linkText("Hotels")).click();
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(0, 300)");
	    webdriver.findElement(By.linkText("Point A Hotel Dublin Parnell Street")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[1]/div[1]/label"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div[2]/section/div[2]/div/div[1]/button"))).click();
	    WebElement tripName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div[2]/section/div[2]/div/form/div[1]/div/div/input")));
	    tripName.sendKeys("Hotel in Dublin");
	    webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/section/div[2]/div/form/div[3]/button")).click();
	    Thread.sleep(2000);
	    String saved = webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/div[1]/div[1]/div/div[2]/div/div[2]")).getText();
	    assertEquals(saved,"Saved");
	    
		}
	}