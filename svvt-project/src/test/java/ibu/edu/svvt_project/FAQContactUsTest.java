package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class FAQContactUsTest {

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

        webDriver.findElement(By.xpath("//html/body/div[1]/header/nav[1]/div/ul/li[1]/div/label")).click();
        webDriver.findElement(By.xpath("/html/body/div[1]/header/nav[1]/div/ul/li[1]/div/div/ul/li[3]/a")).click();
        Thread.sleep(5000);
        //webDriver.findElement(By.xpath("/html/body/div[5]/div/section/div[1]/div/button")).click();
        //Thread.sleep(500);
        //Select dropdown1 = new Select(webDriver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/div/div[2]/div[2]/div/div[1]/label/select")));
        //dropdown1.selectByVisibleText("Something else");
        //Select dropdown2 = new Select(webDriver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div[4]/label/select")));
        //dropdown2.selectByVisibleText("Other issues");
        //WebElement text = webDriver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/div/div[3]/div/div[2]/div[2]/div/ul/li[2]/text()"));
        //String result = text.getText();
        //assertEquals(": +353 1 656 9439", result);
        String url = webDriver.getCurrentUrl();
        assertEquals("https://www.hotels.com/hotel-rewards-pillar/hotelscomrewards.html?intlid=%5BInsight%5D+Rewards+module+%3A%3A+%27Find+out+more%27+clicked", url);

    }
}

