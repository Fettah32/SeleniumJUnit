package BulutluozDersler.day_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {

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

        //driver.quit();

    }

    @Test
    public void test01() {
        // 1- 1- amazon anasayfaya gidelim
                driver.get("https://www.amazon.com");
                String ilkSayfaHandleDegeri = driver.getWindowHandle();



                // 2- url'in  amazon icerdigini test edelim
        String istenenKelime = "amazon";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(istenenKelime));

                // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowHandle = driver.getWindowHandle();

                // 4- title'in Best Buy icerdigini test edelim
        String istenenKelime2 = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(istenenKelime2));

                // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java" + Keys.ENTER);



                // 6- arama sonuclarinin Java icerdigini test edelim
        String aramaSonucu = driver.findElement(By.xpath("//span[@class = 'a-color-state a-text-bold']")).getText();
        String istenenKelime3 = "java";
        Assert.assertTrue(aramaSonucu.contains(istenenKelime3));


                // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWindowHandle);


                // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//*[@class = 'logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
