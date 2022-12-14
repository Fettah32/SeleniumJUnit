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
    assertEquals , beklenen sonucu ger??ek sonu?? ile kar????la??t??rmak i??in kullan??l??r.
     Beklenen sonu?? ile ger??ek sonu?? e??it de??il ise ger??ekle??tirilen test senaryosu
     sonucunda assertionError hatas?? f??rlat??r.

    2. assertTrue
    assertTrue, beklenen bir sonucun true oldu??unun kabul edilmesi gerekti??i zaman kullan??l??r.
    Parametre olarak iki de??er al??r. ??lk parametre de bir mesaj g??nderilir ikinci parametrede
    ise g??nderilen mesaj??n do??rulu??u i??in ko??ul belirlenir.

    3. assertFalse
    assertFalse, beklenen bir sonucun false olmas?? durumunda kullan??l??r. ??ki parametre al??r.
    Parametrelerden biri mesajd??r di??eri ise ko??uldur. assertFalse ile ko??ul yerine getirilmez
    ise assertionError hatas?? f??rlat??r.

    4.assertNull
    assertNull, beklenen bir sonucun null olup olmad?????? kontrol edilmesi i??in kullan??l??r.
    Bir nesneyi parametre olarak al??r ve nesne null de??il ise assertionError hatas?? f??rlat??r.

    5.assertNotNull
    assertNotNull, beklenen bir sonucun null olmad??????n?? do??rulamak i??in kullan??l??r.
    Bir nesneyi parametre olarak al??r ve nesne null ise assertionError hatas?? f??rlat??r.

    6.assertSame
    assertSame, parametre olarak verilen iki nesnenin ayn?? nesneye kar????l??k gelip gelmedi??ini kontrol eder.
    E??er nesneler ayn?? nesneyi kar????lam??yor ise assertionError hatas?? f??rlat??r.

    7.assertNotSame
    assertNotSame, parametre olarak verilen iki nesnenin birbirine e??it olmad?????? kontrol??n?? eder.
    E??er ayn?? nesneye kar????l??k geliyor ise assertionError hatas?? f??rlat??r.

    8.assertArrayEquals
    assertArrayEquals, parametre olarak verilen iki dizinin e??it olup olmad??????n?? kontrol eder.
    Her iki dizi i??inde null de??eri var ise bunlar e??it olarak kabul edilir.
    E??er e??it de??il ise assertionError hatas?? f??rlat??r.
    */

}
