package day_10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {

    /*
    Yeni bir class olusturalim: MouseActions1
https://the-internet.herokuapp.com/context_menu sitesine gidelim
 Cizili alan uzerinde sag click yapalim
Alert’te cikan yazinin “You selected a context menu” oldugunu
test edelim.
Tamam diyerek alert’i kapatalim
Elemental Selenium linkine tiklayalim
Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test
    public void test01() throws Exception {

        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement cizgiliALanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliALanElementi).perform();

        String actualAlertYazisi = driver.switchTo().alert().getText();
        String expectedAlertYazisi = "You selected a context menu";
        Assert.assertEquals(actualAlertYazisi, expectedAlertYazisi);

        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[text() = 'Elemental Selenium']")).click();
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));

        String elementalSelenium = driver.findElement(By.xpath("//h1")).getText();
        String expectedElementalSelenium = "Elemental Selenium";
        Assert.assertEquals(expectedElementalSelenium, elementalSelenium);



    }

}
