package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidationTest {
    String baseUrl = "http://demo.guru99.com/V1/index.php";
    public WebDriver driver;
    public WebElement usernameControl;
    public WebElement passwordControl;
    public WebElement misc;
    public WebElement userValidationMessage;
    public WebElement passwordValidationMessage;

    @BeforeTest
    public void openSite() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void blankTest() {
        usernameControl = driver.findElement(By.name("uid"));
        passwordControl = driver.findElement(By.name("password"));
        misc = driver.findElement(By.cssSelector("body"));
        userValidationMessage = driver.findElement(By.id("message23"));
        passwordValidationMessage = driver.findElement(By.id("message18"));
        usernameControl.click();
        passwordControl.click();
        misc.click();
        String u1 = userValidationMessage.getAttribute("style");
        String u2 = "visibility: visible;";
        String p1 = passwordValidationMessage.getAttribute("style");
        String p2 = "visibility: visible;";
        Assert.assertEquals(u1,  u2);
        Assert.assertEquals(p1, p2);
    }

    @Test
    public void sendKeysTest() {
        usernameControl.sendKeys("a");
        passwordControl.sendKeys("a");
        String u1 = userValidationMessage.getAttribute("style");
        String u2 = "visibility: hidden;";
        String p1 = passwordValidationMessage.getAttribute("style");
        String p2 = "visibility: hidden;";
        Assert.assertEquals(u1,  u2);
        Assert.assertEquals(p1, p2);
    }

    @AfterTest
    public void closeSite() {
        driver.close();
    }
}
