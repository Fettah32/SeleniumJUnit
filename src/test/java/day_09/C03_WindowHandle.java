package day_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {
    /*
    Yeni bir class olusturun: WindowHandle
    Amazon anasayfa adresine gidin.
    Sayfa’nin window handle degerini String bir degiskene atayin
    Sayfa title’nin “Amazon” icerdigini test edin
    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    Sayfa title’nin “Walmart” icerdigini test edin
    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */

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
    public void test01() throws InterruptedException {

        // Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //    Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle = driver.getWindowHandle();

        //    Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        String techProWindowHandle = driver.getWindowHandle();


        //    Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitleTechPro = driver.getTitle();
        String expectedTitleTechPro = "TECHPROEDUCATION";
        Assert.assertFalse(actualTitleTechPro.contains(expectedTitleTechPro));

        //    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        String walmartWindowHandle = driver.getWindowHandle();

        //    Sayfa title’nin “Walmart” icerdigini test edin
        String walmartTitle = driver.getTitle();
        String expectedWalmartTitle = "Walmart";
        Assert.assertTrue(walmartTitle.contains(expectedWalmartTitle));

        //    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertTrue(driver.getTitle().contains(actualTitle));
    }

}
