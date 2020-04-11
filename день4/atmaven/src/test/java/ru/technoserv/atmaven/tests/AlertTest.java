package ru.technoserv.atmaven.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTest {
    String baseUrl = "http://demo.guru99.com/test/delete_customer.php";
    public WebDriver driver;
    public WebDriverWait wait;



    @BeforeTest
    public void openSite() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get(baseUrl);
    }

    @Test
    public void alertTest() {
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        String expectMessage = "Do you really want to delete this Customer?";
        Assert.assertEquals(alertMessage, expectMessage);
        alert.accept();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        String alertMessage2 = driver.switchTo().alert().getText();
        String expectMessage2 = "Customer Successfully Delete!";
        Assert.assertEquals(alertMessage2, expectMessage2);
    }

    @AfterTest
    public void closeSite() {
        driver.quit();
    }
}
