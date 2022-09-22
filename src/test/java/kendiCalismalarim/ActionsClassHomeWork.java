package kendiCalismalarim;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class ActionsClassHomeWork extends TestBaseBeforeAfter {
    /*
    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    2- Hover over Me First" kutusunun ustune gelin
    //Link 1" e tiklayin
    //Popup mesajini yazdirin
    //Popup'i tamam diyerek kapatin
    //"Click and hold" kutusuna basili tutun
    //7-"Click and hold" kutusunda cikan yaziyi yazdirin
    //8- "Double click me" butonunu cift tiklayin
     */

    @Test
    public void test01() throws Exception {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        Thread.sleep(2000);

        // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement HOMFButton = driver.findElement(By.xpath("//button[text() = 'Hover Over Me First!']"));
        actions.moveToElement(HOMFButton).perform();
        Thread.sleep(2000);

        // Link 1" e tiklayin
        driver.findElement(By.xpath("//a[text() = 'Link 1']")).click();
        Thread.sleep(2000);

        // Popup mesajini yazdirin
        String popupMessage = driver.switchTo().alert().getText();
        System.out.println(popupMessage);
        Thread.sleep(2000);

        // Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButton = driver.findElement(By.xpath("//div[@id = 'click-box']"));
        actions.clickAndHold(clickAndHoldButton).perform();
        Thread.sleep(2000);

        // 7-"Click and hold" kutusunda cikan yaziyi yazdirin
        String clickAndHold = clickAndHoldButton.getText();
        System.out.println(clickAndHold);


        // 8- "Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//div[@id = 'double-click']"));
        actions.doubleClick(doubleClick).perform();
        Thread.sleep(2000);
    }
}
