package day_06;

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

public class C02_Assertion {
    /*
    Amazon sayfasina git
    3 farkli test method'u olustur
    - url'in "amazon" icergini test et
    - title'in "facebook" icermedigini test et
    - sol ust kosede amazon logosunun gorundugunu test et
    - URL'in "www.facebook.com" icerdigini test et
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
       //- url'in "amazon" icergini test et
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void test2() {
        // - title'in "facebook" icermedigini test et
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains("facebook"));
    }

    @Test
    public void test3() {
        //- sol ust kosede amazon logosunun gorundugunu test et
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/ref=nav_logo']")).isDisplayed());
    }

    @Test
    public void test4() {
        //- URL'in "www.facebook.com" icerdigini test et
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "www.facebook.com";
        Assert.assertNotEquals(actualUrl, expectedUrl);
    }



    /*
        1. assertEquals
    assertEquals , beklenen sonucu gerçek sonuç ile karşılaştırmak için kullanılır.
     Beklenen sonuç ile gerçek sonuç eşit değil ise gerçekleştirilen test senaryosu
     sonucunda assertionError hatası fırlatır.

    2. assertTrue
    assertTrue, beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
    Parametre olarak iki değer alır. İlk parametre de bir mesaj gönderilir ikinci parametrede
    ise gönderilen mesajın doğruluğu için koşul belirlenir.

    3. assertFalse
    assertFalse, beklenen bir sonucun false olması durumunda kullanılır. İki parametre alır.
    Parametrelerden biri mesajdır diğeri ise koşuldur. assertFalse ile koşul yerine getirilmez
    ise assertionError hatası fırlatır.

    4.assertNull
    assertNull, beklenen bir sonucun null olup olmadığı kontrol edilmesi için kullanılır.
    Bir nesneyi parametre olarak alır ve nesne null değil ise assertionError hatası fırlatır.

    5.assertNotNull
    assertNotNull, beklenen bir sonucun null olmadığını doğrulamak için kullanılır.
    Bir nesneyi parametre olarak alır ve nesne null ise assertionError hatası fırlatır.

    6.assertSame
    assertSame, parametre olarak verilen iki nesnenin aynı nesneye karşılık gelip gelmediğini kontrol eder.
    Eğer nesneler aynı nesneyi karşılamıyor ise assertionError hatası fırlatır.

    7.assertNotSame
    assertNotSame, parametre olarak verilen iki nesnenin birbirine eşit olmadığı kontrolünü eder.
    Eğer aynı nesneye karşılık geliyor ise assertionError hatası fırlatır.

    8.assertArrayEquals
    assertArrayEquals, parametre olarak verilen iki dizinin eşit olup olmadığını kontrol eder.
    Her iki dizi içinde null değeri var ise bunlar eşit olarak kabul edilir.
    Eğer eşit değil ise assertionError hatası fırlatır.
    */

}
