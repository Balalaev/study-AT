package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToolTipTest {
    public String baseUrl = "http://demo.guru99.com/test/social-icon.html";
    public WebDriver driver;
    public WebElement github;

    @BeforeTest
    public void openSite() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void toolTipTest() {
        github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));
        String actualTooltip = github.getAttribute("title");
        String expectedTooltip = "Github";
        Assert.assertEquals(actualTooltip, expectedTooltip);
    }
    @AfterTest
    public void closeSite() {
        driver.quit();
    }
}
