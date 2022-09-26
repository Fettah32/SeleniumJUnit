package kendiCalismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class RegisterUser {
    /*
               1. Launch browser
               2. Navigate to url 'http://automationexercise.com'
               3. Verify that home page is visible successfully
               4. Click on 'Signup / Login' button
               5. Verify 'New User Signup!' is visible
               6. Enter name and email address
               7. Click 'Signup' button
               8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
               9. Fill details: Title, Name, Email, Password, Date of birth
               10. Select checkbox 'Sign up for our newsletter!'
               11. Select checkbox 'Receive special offers from our partners!'
               12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
               13. Click 'Create Account button'
               14. Verify that 'ACCOUNT CREATED!' is visible
               15. Click 'Continue' button
               16. Verify that 'Logged in as username' is visible
               17. Click 'Delete Account' button
               18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        String expectedResult = "https://automationexercise.com/";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        Thread.sleep(2000);
        // 5. Verify 'New User Signup!' is visible
        WebElement newUserWE = driver.findElement(By.xpath("//div[@class='signup-form']"));
        Assert.assertTrue("Webelement gorunmuyor hata", newUserWE.isDisplayed());
        // 6. Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("ghost4d356");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("ghost43215d6@gmail.com");
        Thread.sleep(2000);
        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        Thread.sleep(2000);
        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement eAIYazisi = driver.findElement(By.xpath("//div/h2/b"));
        Assert.assertTrue("Hata aldik yazi gozukmuyor", eAIYazisi.isDisplayed());
        // 9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement titleRadioButton = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        titleRadioButton.click();
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("123456");
        Thread.sleep(2000);
        WebElement dOBDay = driver.findElement(By.xpath("//*[@data-qa = 'days']"));
        Select selectDay = new Select(dOBDay);
        selectDay.selectByVisibleText("30");
        Thread.sleep(2000);
        WebElement dOBMonth = driver.findElement(By.xpath("//*[@data-qa = 'months']"));
        Select selectMonth = new Select(dOBMonth);
        selectMonth.selectByVisibleText("November");
        Thread.sleep(2000);
        WebElement dOBYears = driver.findElement(By.xpath("//*[@id = 'years']"));
        Select selectYears = new Select(dOBYears);
        selectYears.selectByVisibleText("1994");
        Thread.sleep(2000);
        // 10. Select checkbox 'Sign up for our newsletter!'
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        Thread.sleep(2000);
        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        Thread.sleep(2000);
        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//*[@id= 'first_name']"));
        firstName.sendKeys("Adil Fettah");
        Thread.sleep(2000);
        WebElement lastName = driver.findElement(By.xpath("//*[@id = 'last_name']"));
        lastName.sendKeys("YASSIKAYA");
        Thread.sleep(2000);
        WebElement company = driver.findElement(By.xpath("//*[@id = 'company']"));
        company.sendKeys("TechPro");
        Thread.sleep(2000);
        WebElement address = driver.findElement(By.xpath("//*[@id = 'address1']"));
        address.sendKeys("Cumhuriyet mah. 157. Cad. No:21 Kucukcekmece/ISTANBUL");
        Thread.sleep(2000);
        WebElement stateWE = driver.findElement(By.xpath("//input[@id='state']"));
        stateWE.sendKeys("Ingiltere");
        Thread.sleep(2000);
        WebElement cityWE = driver.findElement(By.xpath("//input[@id='city']"));
        cityWE.sendKeys("Londra");
        Thread.sleep(2000);
        WebElement zipCode = driver.findElement(By.xpath("//input[@name='zipcode']"));
        zipCode.sendKeys("8265");
        Thread.sleep(2000);
        WebElement mobileNumber = driver.findElement(By.xpath("//input[@data-qa='mobile_number']"));
        mobileNumber.sendKeys("+28 35426895");
        Thread.sleep(2000);
        WebElement addres2 = driver.findElement(By.xpath("//input[@id='address2']"));
        addres2.sendKeys("bakkalin ordan sola donunce");
        Thread.sleep(2000);
        WebElement dropdownCountry = driver.findElement(By.xpath("(//select[@id='country'])"));
        Select selectCountry = new Select(dropdownCountry);
        selectCountry.selectByVisibleText("Canada");
        Thread.sleep(2000);
        // 13. Click 'Create Account button'
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        // 14. Verify that 'ACCOUNT CREATED!' is visible
        Thread.sleep(5000);
        WebElement accountCreated = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        // 15. Click 'Continue' button
        Thread.sleep(5000);
        driver.findElement(By.linkText("Continue")).click();
        // 16. Verify that 'Logged in as username' is visible
        Thread.sleep(5000);
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//li[10]/a"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());
        // 17. Click 'Delete Account' button
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        // 18.Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String actualYazi = "Delete Account";
        WebElement deleteAccount = driver.findElement(By.xpath("//h1"));
        String deleteAccountYazisi = deleteAccount.getText();
        Assert.assertEquals("ACCOUNT DELETED! gorunmuyor", actualYazi, deleteAccountYazisi);


    }
}
