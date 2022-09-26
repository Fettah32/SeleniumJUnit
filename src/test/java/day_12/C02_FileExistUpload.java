package day_12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileExistUpload extends TestBaseBeforeAfter {

    @Test
    public void test01() throws Exception {
        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSecButtonu=driver.findElement(By.id("file-upload"));

        /*
        Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string değişkene atadığımız dosya yolumuzu
        göndeririz.
         */


        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\90545\\Desktop\\text.txt";
        dosyaSecButtonu.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String fileUploaded = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "File Uploaded!";
        Assert.assertEquals(expectedText, fileUploaded);
    }
}
