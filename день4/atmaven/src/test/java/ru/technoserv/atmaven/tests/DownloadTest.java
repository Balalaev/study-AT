package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class DownloadTest {
    public String baseUrl = "http://demo.guru99.com/test/yahoo.html";
    public String wgetCommand;
    public String sourceLocation;
    public WebDriver driver;
    public WebElement downloadButton;


    @BeforeTest
    public void openSite() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void downloadFileTest() {
        downloadButton = driver.findElement(By.id("messenger-download"));
        sourceLocation = downloadButton.getAttribute("href");
        wgetCommand = "wget -P C:\\Users\\Андрей\\Downloads --no-check-certificate  " + sourceLocation;
        try {
            Process exec = Runtime.getRuntime().exec(wgetCommand);
            int exitVal = exec.waitFor();
            File f = new File("C:\\Users\\Андрей\\Downloads\\msgr11us.exe");
            Assert.assertTrue(f.exists());
            f.delete();
        } catch (InterruptedException | IOException ex) {
            throw new AssertionError(ex.toString());
        }
    }

    @AfterTest
    public void closeSite() {
        driver.quit();
    }
}


