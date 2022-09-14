package day_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //       1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //       2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //       3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //       4- Bulunan sonuc sayisini yazdiralim
        List<WebElement> sonucYazisi = driver.findElements(By.xpath("(//*[@class = 'a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonuc = sonucYazisi.get(0).getText();
        System.out.println(sonuc);

        Arrays.stream(sonuc.split(" ")).limit(3).skip(2).forEach(System.out::println); // sadece sayisi icin.

        //       5- Ilk urunu tiklayalim
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class = 's-image'])[1]"));
        ilkUrun.click();
        //       6- Sayfadaki tum basliklari yazdiralim
        WebElement tumBasliklar = driver.findElement(By.tagName("h1"));
        System.out.println(tumBasliklar.getText());
    }
}
