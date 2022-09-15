package kendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MavenSoru03 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);

        //2.Username kutusuna “standard_user” yazdirin
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        Thread.sleep(2000);
        //3.Password kutusuna “secret_sauce” yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@id = 'password']"));
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        //4.Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        //5.Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class = 'inventory_item_name'])[1]"));
        String ilkUrunIsmi = ilkUrun.getText();
        System.out.println(ilkUrunIsmi);
        ilkUrun.click();
        Thread.sleep(2000);
        //6.Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        //7.Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();
        Thread.sleep(2000);
        //8.Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement contentsContainer = driver.findElement(By.id("cart_contents_container"));
        String actualSepet = contentsContainer.getText();
        String expectedSepet = ilkUrunIsmi;
        if (actualSepet.contains(expectedSepet)) {
            System.out.println("Urun basarili bir sekilde sepete eklendi");
        } else System.out.println("Urun sepete eklenemedi");
        Thread.sleep(2000);
        //9.Sayfayi kapatin
        driver.close();
    }
}
