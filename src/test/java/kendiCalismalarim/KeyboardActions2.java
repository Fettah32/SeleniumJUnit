package kendiCalismalarim;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import static org.openqa.selenium.Keys.PAGE_DOWN;

public class KeyboardActions2 extends TestBaseBeforeAfter {

    /*
    https://html.com/tags/iframe/ sayfasina gidelim
     video’yu gorecek kadar asagi inin
    videoyu izlemek icin Play tusuna basin
    videoyu calistirdiginizi test edin
     */

    @Test
    public void test01() throws InterruptedException {

        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //     video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(PAGE_DOWN).sendKeys(PAGE_DOWN).perform();



        //    videoyu izlemek icin Play tusuna basin
        WebElement iframeVideo = driver.findElement(By.xpath("//iframe[@src = 'https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeVideo);

        Thread.sleep(2000);

        WebElement playButton = driver.findElement(By.xpath("//button[@class = 'ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playButton.click();

        //    videoyu calistirdiginizi test edin
        WebElement video = driver.findElement(By.xpath("//*[@class='video-stream html5-main-video']"));
        Thread.sleep(10000);
        actions.moveToElement(video).perform();
        WebElement pause = driver.findElement(By.xpath("//*[@title='Duraklat (k)']"));
        Assert.assertTrue(pause.isDisplayed());

        Thread.sleep(15000);
    }
}
