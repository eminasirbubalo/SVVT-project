package svvtprojekat;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProjekatTest {

	private static WebDriver webDriver;
	private static String baseUrl;
	


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		webDriver=new ChromeDriver();
		baseUrl="https://www.hotels.com/";
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	@Order(1)
	void testSupport() throws InterruptedException {
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.linkText("Support")).click();
		webDriver.findElement(By.xpath("//*[@id=\"article-title-20776\"]")).click();
		
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("//*[@id=\"article-detail-20776\"]/div[1]/div[1]/button[1]")).click();
		
		
		WebElement feedback=webDriver.findElement(By.xpath("//*[@id=\"article-detail-20776\"]/div[1]"));
		assertEquals("Thank you for your feedback",feedback.getText());
		
		webDriver.get(baseUrl);
	}
	
	@Test
	@Order(2)
	void testContactUs() throws InterruptedException{
		
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.linkText("Support")).click();
		
		
		webDriver.findElement(By.xpath("/html/body/div[5]/div/section/div[1]/div/button")).click();
		Thread.sleep(5000);
		
		Select topic=new Select(webDriver.findElement(By.xpath("//*[@id=\"category-selection\"]")));
		topic.selectByValue("1000");
		
		Select category=new Select(webDriver.findElement(By.xpath("//*[@id=\"sub-category-1000\"]")));
		category.selectByValue("10002");
		
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("//*[@id=\"modalCloseButton\"]/span[1]")).click();		
		
		webDriver.navigate().back();

	}

	
}
