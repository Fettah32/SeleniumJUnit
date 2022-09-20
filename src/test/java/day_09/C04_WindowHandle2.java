package day_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle2 {

    /*
    Tests package’inda yeni bir class olusturun: WindowHandle2
https://the-internet.herokuapp.com/windows adresine gidin.
Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
Click Here butonuna basın.
Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
Sayfadaki textin “New Window” olduğunu doğrulayın.
Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

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
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String text = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, text);



        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text() = 'Click Here']")).click();
        Thread.sleep(2000);
        /*
        Bir web sitesine gittiginizde bir web elementi tikladiginizda yeni bir sekme ya da pencere acilirsa
        bu yeni acilan semenin handle degerini bulabilmek icin driver.getWindowHandles() method'unu bir
        ArrayList'e atip butun sayfalarin listesine ulasabilirim. Ilk actigim pencerenin index'i 0(sifir) dir.
        Ikinci acilan sekmenin index'i 1(bir) dir ve ikinci acilan pencerede ya da sekmede islem yapabilmek icin
        driver.switchTo().window(windowList.get(1)) method'unu kullaniriz.
         */
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        //List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(windowList.get(1));
        /*
        NOT: String'lerden oluşan bir list oluşturup getWindowHandles() method'u ile
        açık bulunan tüm sayfaların / pencerelerin WindowHandle değerlerini o list'e atıyoruz.
        Daha sonra driver.switchTo().window() method'unun içine oluşturduğumuz list'ten
        hangi web sayfasını istiyorsak onun indeksini yazarak sayfalar arasında geçiş yapabiliyoruz.
        Yapı şu şekilde: driver.switchTo().window(listAdı.get(window'un indeks numarası))
        Örneğimizde windowList adındaki list'imizden 1. elementi getirdik.
        0 ilk sayfanın WindowHandle değerini, 1 ise ikinci sayfanın WindowHandle değerini verir.
        */

        /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */


        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";
        Assert.assertEquals(actualTitle2, expectedTitle2);

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualText2 = driver.findElement(By.xpath("//h3")).getText();
        String expectedText2 = "New Window";
        Assert.assertEquals(actualText2, expectedText2);

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }
}
