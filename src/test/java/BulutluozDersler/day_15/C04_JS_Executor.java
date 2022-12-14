package BulutluozDersler.day_15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C04_JS_Executor extends TestBaseBeforeAfter {
    @Test
    public void JSExecutorTest() throws InterruptedException {

        // amazon'a gidelim
        driver.get("https://www.amazon.com");
        // asagidaki sign in butonu gorununceye kadar js ile scrool yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButonu= driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(3000);

        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);
        // sign in butonuna js ile click yapalim

        jse.executeScript("arguments[0].click();",signInButonu);

        Thread.sleep(3000);
    }
}
