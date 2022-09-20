package BulutluozDersler.day_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {

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
        // amazon anasayfaya gidin.
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        // 2- Nutella icin arama yaptirin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        /*
        acilan kod sayfanin unique hash kodudur.
        Selenium sayfalar arasi geciste bu window handle degerini kullanir.

        eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
        su anda bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz.
         */

        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//div[@class = 'a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandigimizda driver otomatik olarak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */
        System.out.println("Driveri'in URL'i : " + driver.getCurrentUrl()); //
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class = 'a-section aok-relative s-image-square-aspect'])[1]")).click();
        System.out.println(driver.getCurrentUrl());





        // 4- Yeni tabda acilan urunun basligini yazdirin
        WebElement urunTITLE = driver.findElement(By.xpath("//span[@id = 'productTitle\']"));
        System.out.println(urunTITLE.getText());

        // ilk sayfaya gecip url yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());

    }
}
