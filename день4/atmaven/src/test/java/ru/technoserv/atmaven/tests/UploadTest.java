package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadTest {
    public String baseUrl = "http://demo.guru99.com/test/upload/";
    public WebDriver driver;
    public WebElement uploadElement;
    public WebElement res;

    @BeforeTest
    public void openSite() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void uploadFileTest() {
        uploadElement = driver.findElement(By.id("uploadfile_0"));
        uploadElement.sendKeys("C://test.txt");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.name("send")).click();
        res = driver.findElement(By.cssSelector("#res"));
        String actualStyle = res.getAttribute("style");
        String expectedStyle = "color: rgb(255, 255, 255); display: none;";
        Assert.assertEquals(actualStyle, expectedStyle);
    }

    @AfterTest
    public void closeSite() {
        driver.quit();
    }
}