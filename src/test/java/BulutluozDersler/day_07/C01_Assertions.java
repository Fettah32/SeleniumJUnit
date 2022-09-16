package BulutluozDersler.day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    /*
    Amazon ana sayfaya gidin
    3 farklı test metodu olusturarak aşagidaki gorevleri yapın
    - 1.Url'nin amazon icerdigini test edin
    -2 Title'in facebook icermedigini test edin
    -3 Sol ust kosede amazon logosunun gorundugunu test edin
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
    public void test01() {
        //- url'in "amazon" icergini test et
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void test02() {
        // - title'in "facebook" icermedigini test et
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains("facebook"));
    }

    @Test
    public void test03() {
        //- sol ust kosede amazon logosunun gorundugunu test et
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/ref=nav_logo']")).isDisplayed());
    }
}
