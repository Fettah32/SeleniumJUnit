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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C03_DropDown {

    WebDriver driver;
    Select select;

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
        //  // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //        //oldugunu testedin
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id = 'searchDropdownBox']"));
        select = new Select(dropDownMenu);
        /*
        Dropdown menuye ulasmak icin Select class'indan bir obje olustururuz.
        Locate ettigimiz dropDown WebElement'ini select class'ina tanimlariz.
        getOptions() method'unu kullanarak Dropdown'i bir List'e atarak
        dropdown menunun butun elemanlarinin sayisina ulasabiliriz.
         */
        List<WebElement> options = select.getOptions();
        int actualOptionsNumbers = options.size();
        System.out.println(actualOptionsNumbers);
        int expectedOptionsNumbers = 45;

        Assert.assertNotEquals(actualOptionsNumbers, expectedOptionsNumbers);

        System.out.println(select.getFirstSelectedOption().getText());

    }

    @Test
    public void test02() {

        //1.Kategori menusunden Books secenegini secin
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id = 'searchDropdownBox']"));
        select = new Select(dropDownMenu);
        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());
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


        /*
        Dropdown menude sectigimiz optiona ulasmak istersek select.getFirstSelectedOption().getText()
        methodunu kullaniriz.
         */


    }
}
