package BulutluozDersler.day_10;

import utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfasina gidip
        driver.get("https://www.amazon.com");

        // account menusunden create a list linkine tiklayalim
        Actions actions = new Actions(driver);
        WebElement accountLinki = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountLinki).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span [text() = 'Create a List']")).click();

        Thread.sleep(7000);

    }
}
