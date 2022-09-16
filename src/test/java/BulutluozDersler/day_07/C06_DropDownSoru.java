package BulutluozDersler.day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDownSoru {
    /*
    ●https://the-internet.herokuapp.com/dropdown adresinegidin.
1.Index kullanarak Seçenek 1’i (Option 1) seçin veyazdırın
2.Value kullanarak Seçenek 2'yi (Option 2) seçin veyazdırın
3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin veyazdırın
4.Tüm dropdown değerleri(value)yazdırın
5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
Falseyazdırın.
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
    public void test() {

        //  ●https://the-internet.herokuapp.com/dropdown adresinegidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin veyazdırın
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id= 'dropdown']"));
        Select select = new Select(dropDownMenu);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin veyazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin veyazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //4.Tüm dropdown değerleri(value)yazdırın
        List<WebElement> dropDownOptions = select.getOptions();
        for (WebElement each: dropDownOptions
             ) {
            System.out.println(each.getText());
        }
        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //Falseyazdırın.
        int actualDropDownBoyut = dropDownOptions.size();
        int expectedDropDownBoyut = 4;
        if (actualDropDownBoyut == expectedDropDownBoyut) {
            System.out.println("True");
        } else System.out.println("False");
    }

}
