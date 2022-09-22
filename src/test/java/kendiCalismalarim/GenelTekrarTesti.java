package kendiCalismalarim;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;
import utilities.TestBaseBeforeClassAfterClass;

import java.nio.file.Watchable;
import java.util.Arrays;
import java.util.List;

import static sun.security.krb5.internal.KDCOptions.with;

public class GenelTekrarTesti extends TestBaseBeforeClassAfterClass {
    /*
    -  amazon gidin
        Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        dropdown menude 40 eleman olduğunu doğrulayın
        Test02
        dropdown menuden elektronik bölümü seçin
        arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        sonuc sayisi bildiren yazinin iphone icerdigini test edin
        ikinci ürüne relative locater kullanarak tıklayin
        ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        Test03
        yeni bir sekme açarak amazon anasayfaya gidin
        dropdown’dan bebek bölümüne secin
        bebek puset aratıp bulundan sonuç sayısını yazdırın
        sonuç yazsının puset içerdiğini test edin
        5-üçüncü ürüne relative locater kullanarak tıklayin
        6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
     */


    @Test
    public void test01() throws Exception {
        // amazon gidin
        driver.get("https://www.amazon.com");

        //        Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id = 'searchDropdownBox']"));
        Select select = new Select(dropDownMenu);
        List<WebElement> dropDown = select.getOptions();
        for (WebElement each: dropDown
             ) {
            System.out.println(each.getText());
        }

        //        dropdown menude 40 eleman olduğunu doğrulayın

        int expectedResult = 40;
        int actualResult = select.getOptions().size();
        System.out.println(actualResult); // 28
        Assert.assertFalse("DropDown menude 40 eleman vardir", actualResult == expectedResult);

    }

    @Test
    public void test02() throws Exception {
        // dropdown menuden elektronik bölümü seçin
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id = 'searchDropdownBox']"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Electronics");

        //        arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        WebElement bulunanSonucYazisi = driver.findElement(By.xpath("//div[@class = 'a-section a-spacing-small a-spacing-top-small']"));
        String bulunanSonuc = bulunanSonucYazisi.getText();
        System.out.println(bulunanSonuc);

        Arrays.stream(bulunanSonuc.split(" ")).limit(3).skip(2).forEach(System.out::println);

        //        sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedVocabulary = "iphone";
        Assert.assertTrue(bulunanSonuc.contains(expectedVocabulary));


        //        ikinci ürüne relative locater kullanarak tıklayin
        WebElement firstResultElement = driver.findElement(By.xpath("(//div[@class = 'a-section aok-relative s-image-square-aspect'])[1]"));
        WebElement thirdResultElement = driver.findElement(By.xpath("(//div[@class = 'a-section aok-relative s-image-square-aspect'])[6]"));

        WebElement secondResultElement = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(firstResultElement));
        secondResultElement.click();


        //        ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
    }


}
