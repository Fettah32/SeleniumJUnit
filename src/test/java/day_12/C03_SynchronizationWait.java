package day_12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeClassAfterClass;

import java.time.Duration;

public class C03_SynchronizationWait extends TestBaseBeforeClassAfterClass {
    /*
    Iki tane metod olusturun : implicitWait() , explicitWait()
    Iki metod icin de asagidaki adimlari test edin.
    https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    Remove butonuna basin.
    “It’s gone!” mesajinin goruntulendigini dogrulayin.
    Add buttonuna basin
    It’s back mesajinin gorundugunu test edin
     */

    @Test
    public void implicitWaitTest01() {
        //  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    Remove butonuna basin.
        driver.findElement(By.xpath("//*[text() = 'Remove']")).click();

        //    “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement ilkMesaj = driver.findElement(By.xpath("//*[@id = 'message']"));
        Assert.assertTrue(ilkMesaj.isDisplayed());

        //    Add buttonuna basin
        driver.findElement(By.xpath("//*[text() = 'Add']")).click();

        //    It’s back mesajinin gorundugunu test edin
        WebElement ikinciMesaj = driver.findElement(By.xpath("//*[@id = 'message']"));
        Assert.assertTrue(ikinciMesaj.isDisplayed());

    }

    @Test
    public void explicitWaitTest02() {

        //  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    Remove butonuna basin.
        driver.findElement(By.xpath("//*[text() = 'Remove']")).click();

        //    “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement messageOne = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'message']")));
        Assert.assertTrue(messageOne.isDisplayed());


        //    Add buttonuna basin
        driver.findElement(By.xpath("//*[text() = 'Add']")).click();

        //    It’s back mesajinin gorundugunu test edin
        WebElement messageTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'message']")));
        Assert.assertTrue(messageTwo.isDisplayed());
    }
}
