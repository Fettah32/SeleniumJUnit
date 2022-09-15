package kendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MavenSoru01 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1.http://zero.webappsecurity.com sayfasinagidin
        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(2000);
        //2.Signin buttonunatiklayin
        driver.findElement(By.xpath("//*[@type = 'button']")).click();
        Thread.sleep(2000);
        //3.Login alanine “username” yazdirin
        WebElement login = driver.findElement(By.xpath("(//*[@autocomplete = 'off'])[1]"));
        login.sendKeys("username");
        Thread.sleep(2000);
        //4.Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("(//*[@autocomplete = 'off'])[2]"));
        password.sendKeys("password");
        Thread.sleep(2000);
        //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@value = 'Sign in']")).click();
        Thread.sleep(2000);
        //6.Pay Bills sayfasina gidin
        driver.navigate().back();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id = 'online-banking']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id = 'pay_bills_link']")).click();
        Thread.sleep(2000);
        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id = 'sp_amount']"));
        amount.sendKeys("25000");
        Thread.sleep(2000);
        //8.tarih kismina “2020-09-10” yazdirin
        WebElement date = driver.findElement(By.xpath("//*[@id = 'sp_date']"));
        date.sendKeys("2020-09-10");
        Thread.sleep(2000);
        driver.findElement(By.className("wrapper")).click();
        Thread.sleep(2000);
        //9.Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        Thread.sleep(2000);
        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement message = driver.findElement(By.xpath("//*[@id = 'alert_content']"));
        String actualMessage = message.getText();
        String expectedMessage = "The payment was successfully submitted.";
        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Message Test Passed");
        } else System.out.println("Message Test Failed, Actual Message : " + actualMessage);

        driver.close();
    }
}
