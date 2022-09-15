package kendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MavenTekrarTesti {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2-https://www.google.com/ adresinegidin
        driver.get("https://www.google.com/");
        //3-cookies uyarisini kabul ederek kapatin
        // Cookies uyarisi cikmadi
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title Test Passed");
        } else System.out.println("Title Test Failed, Actual Title: " + actualTitle);
        //5-Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu = driver.findElement(By.xpath("//*[@name = 'q']"));
        aramaCubugu.sendKeys("Nutella", Keys.ENTER);
        Thread.sleep(2000);
        //6-Bulunan sonuc sayisini yazdirin
        List<WebElement> sonucYazisi = driver.findElements(By.xpath("//*[@id = 'result-stats']"));
        String sonuc = sonucYazisi.get(0).getText().split(" ")[1].replace(".", "");
        System.out.println(sonuc);
        double actualSonuc = Double.parseDouble(sonuc);
        System.out.println(sonuc);


        Arrays.stream(sonuc.split(" ")).limit(2).skip(1).forEach(System.out::println);
        //7-sonuc sayisinin 10 milyon’dan fazla oldugunu testedin

        double expectedSonuc = 10000000;
        if (actualSonuc > expectedSonuc) {
            System.out.println("Sonuc sayisi 10 milyondan fazla");
        } else System.out.println("Sonuc sayisi 10 milyondan az");
        //8-Sayfayi kapatin
        driver.close();
    }
}
