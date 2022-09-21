package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C03_LoginTest {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {

        // 1- https://www.koalaresorthotels.com/ adresine gidelim
        driver.get("https://www.koalaresorthotels.com/");

        // 2- Login butonuna tikla
        driver.findElement(By.xpath("//*[text() = 'Log in']")).click();
        //driver.findElement(By.cssSelector("#navLogon")).click();

        // 3- Login ekranina girdiginizi 4 farkli webelementi kullanarak dogrulayiniz
        WebElement loginYazisi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(loginYazisi.isDisplayed());

        Assert.assertTrue(driver.getTitle().contains("Log in"));

        String expectedUrl = "https://www.koalaresorthotels.com/Account/Logon";
        Assert.assertEquals("Log in ekranina giris yapilmadi", driver.getCurrentUrl() , expectedUrl);

        WebElement loginButtonWE = driver.findElement(By.id("btnSubmit"));
        Assert.assertTrue(loginButtonWE.isEnabled());

        /*
        asserttrue --> dogruysa  onayla geç,      yanlişsa çalışma dur, hata ver, notumu goster.
        assertFalse --> yanlışsa onayla geç,     doğruysa çalışma dur, hata ver, notumu goster
        assertEquals --> eşitse onayla gec,    eşit değilse çalışma dur, hata ver, notumu goster
        assertNotEquals --> eşit değilse onayla geç,     eşitse çalışma dur, hata ver, notumu goster.
         */
    }

}
