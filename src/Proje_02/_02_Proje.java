package Proje_02;

import Proje_01._01_Proje;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.List;

public class _02_Proje extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/login.html");
        Thread.sleep(2000);
        _01_Proje.logın();
        driver.navigate().back();

        WebElement onlineBanking = driver.findElement(By.id("onlineBankingMenu"));
        onlineBanking.click();

        WebElement payyBills = driver.findElement(By.id("pay_bills_link"));
        payyBills.click();

        WebElement payee = driver.findElement(By.id("sp_payee"));
        //Bu bulduğumuz element seçenekleri olan ve birini seçebileceğimiz bir alan.
        Select select = new Select(payee); //payee adresinde bulunan elementleri Select oluşturarak seçme imkanına kavuşuyoruz
        List<WebElement> listPayee = select.getOptions();
        //sonra bunları bir list in içine atıyoruz. webElement ten gelen değişkenleri list e atıyoruz.
        listPayee.get(_01_Proje.random(listPayee.size())).click();
        //list in içindeki seçenekleri random bir şekilde getirip seçiyoruz.

        WebElement account = driver.findElement(By.id("sp_account"));
        Select select1 = new Select(account);
        List<WebElement> listAccount = select1.getOptions();
        listAccount.get(_01_Proje.random(listAccount.size())).click();

        WebElement amount = driver.findElement(By.id("sp_amount"));
        amount.sendKeys("455");

        WebElement date = driver.findElement(By.id("sp_date"));
        date.sendKeys("20222-07-14");

        WebElement description = driver.findElement(By.id("sp_description"));
        description.sendKeys("bu başarılı bir test girişimidir...");
        Thread.sleep(1000);
        WebElement pay = driver.findElement(By.id("pay_saved_payees"));
        pay.click();

        String expected = "The payment was successfully submitted.";
        String actual = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']")).getText();

        Assert.assertEquals("yanlış mesaj",actual,expected);
        if(expected.equals(actual)){
            System.out.println("test başarılı bir şekilde sonuçlanmıştır.");
        }






    }
}
