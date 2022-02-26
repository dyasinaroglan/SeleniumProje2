package Proje_03;

import Proje_01._01_Proje;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.List;

public class _03_Proje extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/login.html");
        _01_Proje.logın();
        driver.navigate().back();

        WebElement onlineBanking = driver.findElement(By.id("onlineBankingMenu"));
        onlineBanking.click();

        WebElement payyBills = driver.findElement(By.id("pay_bills_link"));
        payyBills.click();

        WebElement purchaseForeign = driver.findElement(By.xpath("(//a[@href='#ui-tabs-3'])"));
        purchaseForeign.click();
        Thread.sleep(1000);
        WebElement currency = driver.findElement(By.id("pc_currency"));
        currency.click();
        Select select = new Select(currency);
        List<WebElement> listCurrency = select.getOptions();
        listCurrency.get(randomSayı(listCurrency.size())).click();

        WebElement amount = driver.findElement(By.id("pc_amount"));
        amount.sendKeys("555");

        WebElement dollar = driver.findElement(By.id("pc_inDollars_true"));
        dollar.click();

        boolean isSelect = dollar.isSelected();
        System.out.println(isSelect);
        Thread.sleep(1000);
        WebElement purchase = driver.findElement(By.id("purchase_cash"));
        purchase.click();

        String expected = "Foreign currency cash was successfully purchased.";
        String actual = driver.findElement(By.xpath("//div[@id='alert_content']")).getText();

        Assert.assertEquals("yanlış mesaj",expected,actual);
        if(expected.equals(actual)){
            System.out.println("test başarılı bir şekilde tamamlanmıştır...");
        }


    }
    public static int randomSayı (int size){
        return (int) (Math.random()*size+1);
    }

}