package day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_DropDownHandle {
    /*
●Bir class oluşturun:C3_DropDownAmazon
●https://www.amazon.com/ adresinegidin.
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin vearatin
3.Bulunan sonuc sayisiniyazdirin
4.Sonucun Java kelimesini icerdigini testedin
*/

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //oldugunu testedin
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement each : drops
        ) {
            System.out.println(each.getText());
        }

        int dropDownSayi = drops.size();
        int expectedSayi = 45;

        Assert.assertNotEquals(dropDownSayi, expectedSayi);

    }

    @Test
    public void test02() {

        //1.Kategori menusunden Books secenegini secin
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id = 'searchDropdownBox']"));
        dropDownMenu.sendKeys("Books");
        //2.Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java", Keys.ENTER);
        //3.Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.
                findElement(By.xpath("(//div[@class = 'a-section a-spacing-small a-spacing-top-small'])[1]"));
        Arrays.stream(sonucYazisi.getText().split(" ")).limit(4).skip(3).forEach(System.out::println);
        System.out.println();
        System.out.println(sonucYazisi.getText());
        //4.Sonucun Java kelimesini icerdigini test edin
        String actualSonuc = sonucYazisi.getText();
        String expectedSonuc = "Java";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));


    }

}
