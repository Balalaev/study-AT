package ru.technoserv.atmaven.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TitleTest {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver ;

    @BeforeTest
    public void openSite() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @Test
    public void verifyHomepageTitle() {
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterTest
    public void closeSite() {
        driver.close();
    }
}
