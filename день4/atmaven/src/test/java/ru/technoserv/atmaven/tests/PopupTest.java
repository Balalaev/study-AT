package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class PopupTest {
    String baseUrl = "http://demo.guru99.com/popup.php";
    public WebDriver driver;
    public WebElement userIdElement;
    public WebElement passwordElement;

    @BeforeTest
    public void openSite() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void popupTest() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String childWindow : allWindows)
        {
            if(!mainWindow.equalsIgnoreCase(childWindow))
            {
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                driver.findElement(By.name("btnLogin")).click();
            }
        }
        userIdElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
        Assert.assertTrue(userIdElement.isDisplayed());
        passwordElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));
        Assert.assertTrue(passwordElement.isDisplayed());
    }

    @AfterTest
    public void closeSite() {
        driver.close();
        driver.quit();
    }
}
