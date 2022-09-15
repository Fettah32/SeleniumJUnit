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

public class JUnitCheckBoxTekrarCozumu {

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

        //      a. Verilen web sayfasına gidin.
        //      https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);
        //      b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type = 'checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type = 'checkbox'])[2]"));
        //      c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()) {
            checkBox1.click();
            System.out.println("Checkbox1 seçili değildi onay kutusuna tiklandi");
        } else System.out.println("Checkbox1 zaten seçili");
        Thread.sleep(2000);
        //      d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()) {
            checkBox2.click();
            System.out.println("Checkbox2 seçili değildi onay kutusunu tiklandi");
        } else System.out.println("Checkbox2 zaten seçili");
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {

        driver.close();

    }
}
