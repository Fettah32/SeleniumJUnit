package day_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;

public class C02_WindowHandle {

    WebDriver driver;
    @Before
    public void setUp () {
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
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        Thread.sleep(2000);

        /*
        Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
        driver'ın window handle değerini string bir değişkene atarız
        Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
        String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz
         */

        //2- Url'nin amazon içerdiğini test edelim
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl ="amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowHandleDegeri = driver.getWindowHandle();


        //4- title'in BestBuy içerdiğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "BestBuy";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java" + Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        String aramaSonucu = driver.findElement(By.xpath("//div[@class = 'a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedAramaSonucu = "java";
        Assert.assertTrue(aramaSonucu.contains(expectedAramaSonucu));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);


        //8- Logonun görünürlüğünü test edelim
        WebElement bestBuyLogo = driver.findElement(By.xpath("//img[@class = 'logo']"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());




    }

}
