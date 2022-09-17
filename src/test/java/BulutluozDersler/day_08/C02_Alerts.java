package BulutluozDersler.day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    /*
    ● Bir class olusturun: Alerts
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
    ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    “You successfully clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
    ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    ● Bir metod olusturun: sendKeysAlert
    ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void acceptAlert() throws InterruptedException {
        // ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //    “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text() = 'Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        WebElement resultYazisi = driver.findElement(By.xpath("//p[@id = 'result']"));

        String expectedResult = "You successfully clicked an alert";
        String actualResult = resultYazisi.getText();

        Assert.assertEquals(expectedResult, actualResult);
        Thread.sleep(4000);
    }

    @Test
    public void dismissAlert() throws InterruptedException {
        // ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //    “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        WebElement resultYazisi = driver.findElement(By.xpath("//p[@id = 'result']"));

        String expectedResult = "successfully";
        String actualResult = resultYazisi.getText();

        Assert.assertFalse(actualResult.contains(expectedResult));
        Thread.sleep(4000);
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("//*[text() = 'Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("adil fettah");
        driver.switchTo().alert().accept();

        WebElement resultYazisi = driver.findElement(By.xpath("//p[@id = 'result']"));

        String expectedResult = "adil fettah";
        String actualResult = resultYazisi.getText();

        Assert.assertTrue((actualResult.contains(expectedResult)));
        Thread.sleep(4000);

    }

}
