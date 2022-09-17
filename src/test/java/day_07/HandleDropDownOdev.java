package day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandleDropDownOdev {
    /*
    1.http://zero.webappsecurity.com/ Adresinegidin
    2.Sign in butonunabasin
    3.Login kutusuna “username”yazin
    4.Password kutusuna “password.”yazin
    5.Sign in tusunabasin
    6.Pay Bills sayfasinagidin
    7.“Purchase Foreign Currency” tusunabasin
    8.“Currency” drop down menusunden Eurozone’usecin
    9.“amount” kutusuna bir sayigirin
    10.“US Dollars” in secilmedigini testedin
    11.“Selected currency” butonunusecin
    12.“Calculate Costs” butonuna basin sonra “purchase” butonunabasin
    13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontroledin.
     */

    WebDriver driver;
    Select select;

    @Before
            public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();


    }

    @Test
    public void test() throws InterruptedException {

        //  1.http://zero.webappsecurity.com/ Adresinegidin
        driver.get("http://zero.webappsecurity.com/");
        Thread.sleep(1000);

        //    2.Sign in butonunabasin
        driver.findElement(By.xpath("//*[@id = 'signin_button']")).click();
        Thread.sleep(1000);

        //    3.Login kutusuna “username”yazin
        WebElement loginButton = driver.findElement(By.xpath("//*[@id = 'user_login']"));
        loginButton.sendKeys("username");
        Thread.sleep(500);

        //    4.Password kutusuna “password”yazin
        WebElement passwordButton = driver.findElement(By.xpath("//*[@id = 'user_password']"));
        passwordButton.sendKeys("password");
        Thread.sleep(500);

        //    5.Sign in tusunabasin
        driver.findElement(By.xpath("//*[@value = 'Sign in']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(3000);

        //    6.Pay Bills sayfasinagidin
        driver.findElement(By.xpath("//*[@id = 'online-banking']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id = 'pay_bills_link']")).click();
        Thread.sleep(2000);


        //    7.“Purchase Foreign Currency” tusunabasin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        Thread.sleep(2000);

        //    8.“Currency” drop down menusunden Eurozone’u secin
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id = 'pc_currency']"));
        select = new Select(dropDownMenu);
        select.selectByVisibleText("Eurozone (euro)");
        Thread.sleep(2000);


        //    9.“amount” kutusuna bir sayigirin
        WebElement amount = driver.findElement(By.xpath("//*[@id = 'pc_amount']"));
        amount.sendKeys("350000");



        //    10.“US Dollars” in secilmedigini testedin
        WebElement USDollarsRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(USDollarsRadioButton.isSelected());
        Thread.sleep(2000);

        //    11.“Selected currency” butonunusecin
        driver.findElement(By.id("pc_inDollars_false")).click();
        Thread.sleep(2000);

        //    12.“Calculate Costs” butonuna basin sonra “purchase” butonunabasin
        driver.findElement(By.id("pc_calculate_costs")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("purchase_cash")).click();
        Thread.sleep(2000);


        //    13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontroledin.
        WebElement alertYazisi = driver.findElement(By.xpath("//div[@id = 'alert_content']"));
        String expectedAlert = "Foreign currency cash was successfully purchased.";
        String actualAlert = alertYazisi.getText();

        Assert.assertEquals(expectedAlert, actualAlert);

        Thread.sleep(2000);

    }

}
