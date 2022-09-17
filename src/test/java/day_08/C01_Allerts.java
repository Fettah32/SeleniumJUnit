package day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {

    /*
    - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    - Click for js Alert butonuna tiklayalim
    - Tikladiktan sonra cikan uyari mesajin (alert'e) tamam diyelim
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
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        //    - Click for js Alert butonuna tiklayalim
        driver.findElement(By.xpath("//*[text() = 'Click for JS Alert']")).click();
        Thread.sleep(1000);

        //    - Tikladiktan sonra cikan uyari mesajin (alert'e) tamam diyelim
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

    }
}
