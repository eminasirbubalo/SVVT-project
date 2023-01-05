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
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateAccountDetails {
	
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
	 void UpdateAccDetails() throws InterruptedException {
	    webdriver.get(baseUrl);
	    webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[1]/div[4]/header/nav/div/div[4]/button")).click();
	    Thread.sleep(1000);
	    webdriver.findElement(By.linkText("Sign in")).click();
	    //sign in
	    WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginFormEmailInput")));
	    email.sendKeys("onijasmoparadva@gmail.com");
	    WebElement password = webdriver.findElement(By.id("loginFormPasswordInput"));
	    password.sendKeys("Passw0rd123!");
	    webdriver.findElement(By.id("loginFormSubmitButton")).click();
	    //go to account
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[1]/div[4]/header/nav/div/div[4]/button"))).click();  
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Account"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[1]/div/ul/li[1]/a"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" /html/body/div[2]/div/div/div[1]/div/ul/li[1]/div[2]/div[2]/button"))).click();
	    //change zip number
	    WebElement zip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-details-zip")));
	    zip.sendKeys("71000");
	    webdriver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/ul/li[1]/div[2]/div[3]/form/button[1]")).click();
	    //check if saved
	    WebElement updateSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[1]/div/ul/li[1]/div[2]/div[1]/div")));
	    assertEquals(updateSuccess.getText(),"Changes to your details have been saved.");
	    Thread.sleep(1000);
	 
	}

}
