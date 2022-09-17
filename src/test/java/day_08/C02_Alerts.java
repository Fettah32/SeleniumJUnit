package day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    /*
    Bir web sitesine girdigimizde krasimiza bir uyari mesaji ya da bir butona tikladigimizda bir uyari(alert)
    cikabilir. Eger bu uyariya incele(mouse sag tik inspect) yapabiliyorsak bu tur alert'lere HTML alert denir.
    Ve istedigimiz locate'i alabiliriz.

    Ama gelen uyari kutusuna mudahale (sag tik-incele) edemiyorsak bu tur alert'lere js alert denir. JS alert'lere
    mudahale edebilmek icin
        - Tamam ya da OK icin --> driver.switchTo().alert().accept() kullanilir.
        - Iptal icin --> driver.switchTo().alert().dismiss() method'u kullanilir.
        - Alert icindeki mesaji almak icin --> driver.switchTo().alert().getText() kullamilir
        - Alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("") kullanilir.
     */


    /*
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
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
    public void test01() throws InterruptedException {
        // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text() = 'Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        WebElement resultYazisi = driver.findElement(By.xpath("//*[@id = 'result']"));
        String actualResult = resultYazisi.getText();
        String expectedResult ="You successfully clicked an alert";
        Assert.assertEquals(expectedResult, actualResult );
        Thread.sleep(2000);

    }

    @Test
    public void test02() throws InterruptedException {
        // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //    “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']")).click();
        Thread.sleep(2000);

        // Alert uzerindeki mesaji yazdirin
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);

        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);



        WebElement resultYazisi = driver.findElement(By.xpath("//*[@id = 'result']"));
        String actualResult = resultYazisi.getText();
        String expectedResult ="successfully";
        Assert.assertFalse(actualResult.equals(expectedResult));
        Thread.sleep(2000);
    }

    @Test
    public void test03() throws InterruptedException {
        // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("//*[text() = 'Click for JS Prompt']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Adil Fettah");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        WebElement resultYazisi = driver.findElement(By.xpath("//*[@id = 'result']"));
        String actualResult = resultYazisi.getText();
        String expectedResult ="Adil Fettah";

        Assert.assertTrue(actualResult.contains(expectedResult));


    }

}
