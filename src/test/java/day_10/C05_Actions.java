package day_10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() {

        // 1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");


        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragMe = driver.findElement(By.xpath("//div [@id = 'draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("//div [ @id = 'droppable']"));
        actions.dragAndDrop(dragMe, dropHere).perform();



        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dropped = driver.findElement(By.xpath("//p[text() = 'Dropped!']"));
        String expectedYazi = "Dropped!";
        String actualYazi = dropped.getText();

        Assert.assertEquals(expectedYazi, actualYazi);
    }

}
