package BulutluozDersler.day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {

        driver.quit();

    }

    @Test
    public void test01() {

        /*
        Herhangi bir web sitesine gidince veya
        bir web sitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz.

        Eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilabilr,
        bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
        tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz.
        - driver.get("https://www.facebook.com"); ' da cikan alert vb....

        Ancak web uygulamalarinda HTML alert yaninda Java Script alert de bulunabilir
        JS alert'ler locate edilemez
        Selenium'da JS alert'ler icin ozel bir yontem gelistirilmistir.
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text() = 'Click for JS Alert']")).click();

        // alert'te OK tusuna basin
        driver.switchTo().alert().accept();

         // result kisminda "You successfully clicked an alert" yazisinin ciktigini test edin.
        WebElement resultYazisi = driver.findElement(By.xpath("//p[@id = 'result']"));

        String expectedResult = "You successfully clicked an alert";
        String actualResult = resultYazisi.getText();

        Assert.assertEquals(expectedResult, actualResult);



    }

}
