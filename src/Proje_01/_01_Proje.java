package Proje_01;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class _01_Proje extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://zero.webappsecurity.com/login.html");
        logın();
        driver.navigate().back();

        WebElement transferFunds = driver.findElement(By.cssSelector("span[id='transfer_funds_link']"));
        transferFunds.click();

        WebElement fromAccount = driver.findElement(By.cssSelector("select[id='tf_fromAccountId']"));
        Select select = new Select(fromAccount);
        List<WebElement> fromAccountList = select.getOptions();

        fromAccountList.get(random(fromAccountList.size())).click();

        WebElement toAccount = driver.findElement(By.cssSelector("select[name='toAccountId']")); //seçenekleri olan bir element seçeceğiz
        //bu yüzden select new etmemiz lazım. select ne olmalı webElement den bir değişken olmalı
        Select select1 = new Select(toAccount);
        //bu seçenekelr neler ise bunları List e almamız lazım
        List<WebElement> toAccountList = select1.getOptions(); //bu seçenekleri bir listeye atıp getOptions methodu ile oluşturuyoruz
        //bu list de oluşturduğumuz seçenekelri random bir şekilde secme yapacağız

        toAccountList.get(random(toAccountList.size())).click();

        WebElement amount = driver.findElement(By.cssSelector("input[id='tf_amount']"));
        amount.sendKeys("500");

        WebElement description = driver.findElement(By.cssSelector("input[id='tf_description']"));
        description.sendKeys("asdsd");
        Thread.sleep(1000);
        WebElement continueButton = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
        continueButton.click();

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement message = driver.findElement(By.cssSelector("div[class='alert alert-success']"));
        String expected = "You successfully submitted your transaction.";
        String actual = message.getText();

        Assert.assertEquals("YANLIŞ MESAJ",expected,actual);
        if(expected.equals(actual)){
            System.out.println("test başarılı bir şekilde tamamlanmıştır...");
        }
        driver.quit();

    }

    public static void logın (){
        WebElement gırıs = driver.findElement(By.cssSelector("input[name='user_login']"));
        gırıs.sendKeys("username");

        WebElement sifre = driver.findElement(By.cssSelector("input[id='user_password']"));
        sifre.sendKeys("password");

        WebElement sıgnIn = driver.findElement(By.cssSelector("input[class='btn btn-primary']"));
        sıgnIn.click();
    }
    public static int random(int size){
        return (int) (Math.random()*size);
    }
}
