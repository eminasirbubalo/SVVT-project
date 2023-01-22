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
	 void SearchWithFilters() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) webdriver;
		webdriver.get(baseUrl);
		//choose place
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section/form/div/div/div[1]/div/div/div/div[1]/div[1]/button"))).click();
		WebElement goingTo = webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section/form/div/div/div[1]/div/div/div/div[2]/div[1]/div/input"));
	    goingTo.sendKeys("Zagreb");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"destination_form_field-menu\"]/div[2]/div[2]/ul/li[1]/button"))).click();
	    //choose dates
	    webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section/form/div/div/div[2]/div/div/div/div/button[1]")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[2]/button"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[5]/button"))).click();
	    webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section/form/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/button"));
	    webdriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/section/form/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/button")).click();
	    Thread.sleep(2000);
	    webdriver.findElement(By.id("search_button")).click();
	    Thread.sleep(2000);
	    js.executeScript("window.scrollBy(0, 800)");
	    Thread.sleep(1000);
	    //filter
	    webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/main/div/div/div/div/div[2]/section[2]/div/div[2]/div/div[1]/section/div[2]/form/div[2]/div[6]/fieldset/div[2]/div[1]/div/div[2]/div/div/input")).click();
	    webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/main/div/div/div/div/div[2]/section[2]/div/div[2]/div/div[1]/section/div[2]/form/div[2]/div[3]/fieldset/fieldset/div[2]/div/label/input")).click();
	    webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/main/div/div/div/div/div[2]/section[2]/div/div[2]/div/div[1]/section/div[2]/form/div[2]/div[4]/div/div/div[5]/label")).click();
	  
	    String text =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/main/div/div/div/div/div[2]/section[2]/div/div[2]/div/div[2]/section/header/div/div[1]/div/div"))).getText();
	    assertEquals(text,"2 properties");
	}
	
}