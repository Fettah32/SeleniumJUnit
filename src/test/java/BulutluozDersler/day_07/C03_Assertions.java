package BulutluozDersler.day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {

    /*
    1.Bir Class olusturalimYanlisEmailTesti
    2.http://automationpractice.com/index.php sayfasinagidelim
    3.Sign in butonunabasalim
    4.Email kutusuna @isareti olmayan bir mail yazipenter’a
    bastigimizda “Invalid email address” uyarisi ciktigini testedelim
     */

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // 2.http://automationpractice.com/index.php sayfasinagidelim
        driver.get("http://automationpractice.com/index.php");
        //    3.Sign in butonunabasalim
        driver.findElement(By.xpath("//a[@class = 'login']")).click();
        Thread.sleep(2000);
        //    4.Email kutusuna @isareti olmayan bir mail yazip enter’a
        //    bastigimizda “Invalid email address” uyarisi ciktigini testedelim
        WebElement mailKutusu = driver.findElement(By.xpath("//input[@id = 'email_create']"));
        mailKutusu.sendKeys("adilyassikayagmail.com" + Keys.ENTER);

        WebElement uyariYazisiElementi = driver.findElement(By.id("create_account_error"));
        Assert.assertTrue(uyariYazisiElementi.isDisplayed());


    }
}
