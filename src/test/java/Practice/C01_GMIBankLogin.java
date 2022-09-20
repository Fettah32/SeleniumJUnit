package Practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GMIBankLogin {

    public static void main(String[] args) {

        // 1-) https://www.gmibank.com adresine gidin.
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.gmibank.com");

        // 2-) Sign In butonuna tikla

        driver.findElement(By.xpath("(//a[@class = 'dropdown-toggle nav-link'])[2]")).click();

        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();

        WebElement userName = driver.findElement(By.xpath("//input[@name = 'username']"));
        userName.sendKeys("Batch81");

        WebElement password = driver.findElement(By.xpath("//input [ @name = 'password']"));
        password.sendKeys("Batch81+");

        driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();


        driver.close();
    }
}
