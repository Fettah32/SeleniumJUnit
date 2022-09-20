package kendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class A101 {

    /*
    Uçtan uca ödeme ekranına kadar Selenium’da java dili ile chrome browser kullanarak test otomasyon ödevi yapılacak.

    Ödeme ekranı doldurulmayacak. Aşağıdaki senaryoyu web ve mobil olmak üzere 2 çeşit oluşturabilirlerse çok iyi olur.
     En az Web’de yapmak zorunlu.
    - Senaryoya üye kaydı oluşturmadan devam edilecek.
    - Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
    - Açılan ürünün siyah olduğu doğrulanır.
    - Sepete ekle butonuna tıklanır.
    - Sepeti Görüntüle butonuna tıklanır.
    - Sepeti Onayla butonuna tıklanır.
    - Üye olmadan devam et butonuna tıklanır.
    - Mail ekranı gelir.
    - Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
    - Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.


     */

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.a101.com.tr");
    }

    @After
    public void tearDown() {

        //driver.quit();

    }

    @Test
    public void test() throws InterruptedException {

        // - Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
        driver.findElement(By.xpath("//button[text() = 'Kabul Et']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@title = 'GİYİM & AKSESUAR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-value = '1565']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-value = '1567']")).click();
        Thread.sleep(2000);



        //    - Açılan ürünün siyah olduğu doğrulanır.
        //WebElement acilanUrun = driver.findElement(By.linkText("Penti Kadın 50 Denye Pantolon Çorabı Siyah"));
        //String actualAcilanUrun = acilanUrun.getText();
        //String expectedAcilanUrun = "Siyah";

        //Assert.assertTrue(actualAcilanUrun.contains(expectedAcilanUrun));

        //    - Sepete ekle butonuna tıklanır.
        driver.findElement(By.xpath("(//*[@class = 'hidden-mobile'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@data-pk = '18864'])[5]")).click();
        Thread.sleep(2000);

        //    - Sepeti Görüntüle butonuna tıklanır.
        driver.findElement(By.xpath("(//*[text() = 'Sepeti Görüntüle'])[2]")).click();
        Thread.sleep(2000);

        //    - Sepeti Onayla butonuna tıklanır.
        driver.findElement(By.xpath("//a[@class = 'button green checkout-button block js-checkout-button']")).click();
        Thread.sleep(2000);

        //    - Üye olmadan devam et butonuna tıklanır.
        driver.findElement(By.xpath("//a[@class = 'auth__form__proceed js-proceed-to-checkout-btn']")).click();
        Thread.sleep(2000);
        //    - Mail ekranı gelir.
        WebElement mailEkrani = driver.findElement(By.xpath("//*[@name = 'user_email']"));
        mailEkrani.sendKeys("adilyassikaya@gmail.com");
        Thread.sleep(2000);
        //    - Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
        driver.findElement(By.xpath("//button [ @class = 'button block green']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title = 'Yeni adres oluştur']")).click();
        Thread.sleep(2000);
        WebElement adresBasligi = driver.findElement(By.xpath("//*[@placeholder = 'Ev adresim, iş adresim vb.']"));
        adresBasligi.sendKeys("ev");

        WebElement ad = driver.findElement(By.xpath("//*[@name = 'first_name']"));
        ad.sendKeys("Adil");

        WebElement soyAd = driver.findElement(By.xpath("//*[@name = 'last_name']"));
        soyAd.sendKeys("Yassikaya");

        WebElement phoneNumber = driver.findElement(By.xpath("//*[@name = 'phone_number']"));
        phoneNumber.sendKeys("5422276670");

        WebElement sehir = driver.findElement(By.xpath("//*[@name = 'city']"));
        Select select = new Select(sehir);
        select.selectByVisibleText("ADANA");

        WebElement ilce = driver.findElement(By.xpath("//*[@name = 'township']"));
        select = new Select(ilce);
        select.selectByVisibleText("CEYHAN");

        WebElement district = driver.findElement(By.xpath("//*[@name = 'district']"));
        select = new Select(district);
        select.selectByValue("122");
        Thread.sleep(2000);

        driver.findElement(By.className("js-address-textarea")).sendKeys("caminin yanindaki guzel ev");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class = 'button green js-set-country js-prevent-emoji']")).click();

        //    - Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.


    }

}
