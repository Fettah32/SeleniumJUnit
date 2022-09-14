package day_05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    //  @Before da method ismi genelde setup olur ama istedigimiz isimde olabilir

    WebDriver driver;
    @Before
    // Before notasyonu her testten once calisir.
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void method1() {
        // Bir defa before methodu calisir
        driver.get("https://www.amazon.com/");
        // Bir defa da after methodu calisir
    }

    @Test
    public void method2() {
        // Bir defa before methodu calisir
        driver.get("https://www.techproeducation.com");
        // Bir defa da after methodu calisir
    }

    @Test
    public void method3() {
        // Bir defa before methodu calisir
        driver.get("https://www.hepsiburada.com");
        // Bir defa da after methodu calisir
    }

    @After
    // After testi her testten sonra calisir.
    public void tearDown() {

        driver.close();

    }
}
