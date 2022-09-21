package BulutluozDersler.day_10;

import utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_KeyboardActions extends TestBaseBeforeAfter {

    @Test
    public void test01() throws InterruptedException {
        // facebook ana sayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        // isim kutusunu locate edip
        // geriye kalan alanlari TAB ile dolasarak formu doldurun.
        Actions actions = new Actions(driver);
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name = 'firstname']"));
        isimKutusu.sendKeys("Adil Fettah");
        Thread.sleep(2000);

        actions.sendKeys(Keys.TAB).sendKeys("YASSIKAYA");
        actions.sendKeys(Keys.TAB).sendKeys("adilyassikaya@gmail.com");
        actions.sendKeys(Keys.TAB).sendKeys("adilyassikaya@gmail.com");
        actions.sendKeys(Keys.TAB).sendKeys("asdfg12345");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("30");
        actions.sendKeys(Keys.TAB).sendKeys("Kas");
        actions.sendKeys(Keys.TAB).sendKeys("1994");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);




    }
}
