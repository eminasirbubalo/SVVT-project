package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class LogoutTest {

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
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[1]/div[4]/header/nav/div/div[4]/button")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(5000);
        WebElement email = webDriver.findElement(By.id("loginFormEmailInput"));
        email.sendKeys("sirbubaloe@gmail.com");
        WebElement password = webDriver.findElement(By.id("loginFormPasswordInput"));
        password.sendKeys("Passw0rd123!");
        webDriver.findElement(By.id("loginFormSubmitButton")).click();

        Thread.sleep(10000);
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[1]/div[4]/header/nav/div/div[4]/button")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[1]/div[4]/header/nav/div/div[4]/div/div[2]/a[6]")).click();

        WebElement button = webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div[1]/div[4]/header/nav/div/div[4]/button"));
        String buttonText = button.getText();

        assertEquals("Sign in", buttonText);

    }
}

