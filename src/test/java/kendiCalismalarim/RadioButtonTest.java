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

public class RadioButtonTest {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test() throws InterruptedException {

        // -https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //-Cookies’i kabul edin
        // No cookies.
        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(2000);
        //-“radio buttons” elementlerini locate edin
        WebElement femaleRadioButton = driver.findElement(By.xpath("(//*[@name = 'sex'])[1]"));
        WebElement maleRadioButton = driver.findElement(By.xpath("(//*[@name = 'sex'])[2]"));
        WebElement customRadioButton = driver.findElement(By.xpath("(//*[@name = 'sex'])[3]"));
        Thread.sleep(2000);
        //-Secili degilse cinsiyet butonundan size uygun olani secin
        maleRadioButton.click();
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
