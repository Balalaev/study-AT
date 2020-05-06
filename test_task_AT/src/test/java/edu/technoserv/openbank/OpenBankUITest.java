package edu.technoserv.openbank;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OpenBankUITest {
    @BeforeTest
    public void openGoogle(){
        open("https://www.google.com/ ");
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;


    }

    @Test
    public void googleSearch(){
        $(By.name("q")).sendKeys("Открытие");
        $(By.xpath("//div[@class='hsuHs']")).submit();
        Assert.assertNotNull($(By.id("search")),"www.open.ru");
        $(By.xpath("//div[@class='r']/a/h3")).click();

        Double usdBuy = Double.parseDouble($(
                By.xpath(
                "//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/div/span"))
                .getText().replace(",", "."));

        Double usdSell = Double.parseDouble($(
                By.xpath(
                "//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div/span"))
                .getText().replace(",", "."));

        Double euroBuy = Double.parseDouble($(
                By.xpath(
                        "//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[3]/td[2]/div/span"))
                .getText().replace(",", "."));

        Double euroSell = Double.parseDouble($(
                By.xpath(
                        "//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[3]/td[4]/div/span"))
                .getText().replace(",", "."));

        Assert.assertTrue(usdSell > usdBuy);
        Assert.assertTrue(euroSell > euroBuy);
    }
}
