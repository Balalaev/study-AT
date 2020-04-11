package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.PortUnreachableException;

public class LoginTest {
    public String baseUrl = "http://demo.guru99.com/test/login.html";
    public WebDriver driver ;
    public WebElement email;
    public WebElement password;
    public WebElement login;

    @BeforeTest
    public void openSite() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test(priority = 0)
    public void sendKeys() {
        email = driver.findElement(By.id("email"));
        password = driver.findElement(By.name("passwd"));
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
    }

    @Test(priority = 1)
    public void clearFields() {
        email = driver.findElement(By.id("email"));
        password = driver.findElement(By.name("passwd"));
        email.clear();
        password.clear();
    }

    @Test(priority = 2)
    public void clickLoginTest() {
        login = driver.findElement(By.id("SubmitLogin"));
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.click();
        String actual = driver.findElement(
                By.cssSelector("body > div:nth-child(2) > div > div > h3")).getText();
        String expected = "Successfully Logged in...";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 3)
    public void submitLoginTest() {
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
        driver.findElement(By.id("SubmitLogin")).submit();
        String actual = driver.findElement(
                By.cssSelector("body > div:nth-child(2) > div > div > h3")).getText();
        String expected = "Successfully Logged in...";
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void closeSite() {
        driver.quit();
    }
}
