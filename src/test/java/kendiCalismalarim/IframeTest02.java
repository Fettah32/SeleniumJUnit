package kendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframeTest02 {
    /*
    http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    sayfadaki iframe sayısını bulunuz.
    ilk iframe'deki (Youtube) play butonuna tıklayınız.
    ilk iframe'den çıkıp ana sayfaya dönünüz
    ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    tıklayınız
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
    public void test() throws InterruptedException {

        // http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        String guru99WebHandle = driver.getWindowHandle();

        //    sayfadaki iframe sayısını bulunuz.
        int iframeSayisi = driver.findElements(By.xpath("//iframe")).size();
        System.out.println("iframe sayisi : " + iframeSayisi);


        //    ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iframe = driver.findElement(By.xpath("//*[@src = 'https://www.youtube.com/embed/RbSlW8jZFe8']"));
        driver.switchTo().frame(iframe);
       WebElement playTusu = driver.findElement(By.xpath("//button[@class = 'ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
       playTusu.click();



        //    ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //    ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //    tıklayınız
        WebElement iframe2 = driver.findElement(By.xpath("//*[@src = 'ads.html']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//img[@src = 'Jmeter720.png']")).click();


    }

}
