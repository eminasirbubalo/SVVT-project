package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UnregisteredUserListMyPropertyTest {

    private static WebDriver webDriver;
    private static String baseUrl1;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/makalijevic/Desktop/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        webDriver = new ChromeDriver(options);
        baseUrl1 = "https://www.hotels.com/";
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        webDriver.quit();
    }

    @Test
    void Task() throws InterruptedException{
        webDriver.get(baseUrl1);
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,550)", "");

        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[6]/div/section/div/div[1]/p/a")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("/html/body/div[1]/header/nav[2]/div/ul/li[2]/a")).click();
        Thread.sleep(5000);
        Set<String> p = webDriver.getWindowHandles();
        webDriver.switchTo().window(p.iterator().next());
        webDriver.navigate().to("https://www.vrbo.com/en-gb/list/property-details?theme=mvp&utm_medium=referral&utm_source=ULX_MVP&utm_term=unknown&utm_campaign=SECUREWELCOMEREWARDS&utm_medium=referral&lasttouchMktgcode=unknown&utm_source=HCOM_EMEA-en_IE&utm_content=header-link");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div[2]/section/div/div/div/div[2]/button[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div[2]/section/div/div/div/div[4]/button")).click();
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div[2]/section/div/div/div/div/div[2]/div[2]/input")).sendKeys("Francuske revolucije,");
        Thread.sleep(2500);
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div[2]/section/div/div/div/div/div[2]/div[2]/ul/li")).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div[2]/section/div/div/div/div/div[5]/button")).click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,400)", "");
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div[2]/section/div/div/div/div[4]/div/div[5]/div[1]/label[2]/input")).sendKeys("71210");
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div[2]/section/div/div/div/div[4]/button")).click();
        WebElement span = webDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[2]/section/div/div/div/h1/span/span"));
        String result = span.getText();

        assertEquals("Create your account", result);

    }
}
