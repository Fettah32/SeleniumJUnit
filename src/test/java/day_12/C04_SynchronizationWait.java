package day_12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C04_SynchronizationWait extends TestBaseBeforeAfter {
    @Test
    public void isEnabled() {

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Textbox’in etkin olmadigini(enabled) dogrulayın
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type = 'text']")).isEnabled());

        //Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath("//button[text() = 'Enable']")).click();
        WebElement enableButton = driver.findElement(By.xpath("//input[@type = 'text']"));
        wait.until(ExpectedConditions.elementToBeClickable(enableButton));



        //“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id = 'message']")));
        Assert.assertTrue(message.isDisplayed());

        //Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type = 'text']")).isEnabled());
    }
}
