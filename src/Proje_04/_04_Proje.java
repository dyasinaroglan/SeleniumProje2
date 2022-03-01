package Proje_04;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.WeakHashMap;

public class _04_Proje extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");

        WebElement[][] webElements = new WebElement[5][];
        webElements[0] = new WebElement[4];
        webElements[1] = new WebElement[4];
        webElements[2] = new WebElement[4];
        webElements[3] = new WebElement[3];
        webElements[4] = new WebElement[6];

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");

        List<WebElement> students = driver.findElements(By.cssSelector("li[id^='node']"));
        students.forEach(webElement -> System.out.println(webElement.getText()));

        List<WebElement> teams = driver.findElements(By.cssSelector("ul[id^='box']"));
        for (WebElement team : teams) {
            System.out.println("yaz"+team.getText());

        }
        System.out.println(teams.size());
        System.out.println(students.size());

        Actions builder = new Actions(driver);
        Action action;

        Thread.sleep(1000);
        int ogrenciSayisi=0;


        for (int i = 0; i < webElements.length; i++) {
            for (int j = 0; j < webElements[i].length; j++) {
                action= builder.clickAndHold(students.get(ogrenciSayisi)).moveToElement(teams.get(i)).build();
                // action=builder.dragAndDrop(students.get(j),teams.get(i)).build();

                action.perform();
                Thread.sleep(1000);
                action = builder.release(teams.get(i)).build();
                action.perform();
                Thread.sleep(100);
                ogrenciSayisi++;

                if (j == webElements[i].length) break;

            }



        }
        List<WebElement> boxList;

        for (int i = 1; i <= webElements.length; i++) {
            boxList = driver.findElements(By.cssSelector("ul#box" + i  + " li"));//li den önce boşluk var ,dikkat
            Assert.assertEquals(boxList.size(),webElements[i-1].length);

        }

        Thread.sleep(2000);
        driver.quit();
            }
        }
