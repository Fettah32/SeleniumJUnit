package BulutluozDersler.day_11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBaseBeforeAfter {


    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. dummy.txt dosyasını indirelim
        WebElement demLinki= driver.findElement(By.xpath("//a[text()='dem.txt']"));
        demLinki.click();
        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim

        String farkliKisim= System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\dem.txt";

        String arananDosyaYolu= farkliKisim+ortakKisim;

        // geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));











    }
}
