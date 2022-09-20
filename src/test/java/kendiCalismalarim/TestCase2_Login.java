package kendiCalismalarim;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class TestCase2_Login extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        Thread.sleep(2000);

        // 3. Verify that home page is visible successfully
        //------>url  /  title /  belirgin webelementler
        String expectedUrl = "https://automationexercise.com";
        String actualUrl = driver.getCurrentUrl();
        //   Assert.assertFalse("siteye ulaşılamıyor",expectedUrl.equals(actualUrl));
        Assert.assertNotEquals("site adresleri ayni", expectedUrl, actualUrl);
        //   WebElement homepageYAzi = driver.findElement(By.xpath("(//a[@href='/'])[2]"));
        //     Assert.assertTrue("homepage elemnti gorunmuyor",homepageYAzi.isDisplayed());

        //  4. Click on 'Signup / Login' button
        WebElement signupLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signupLoginButton.click();
        //  5. Verify 'Login to your account' is visible
        WebElement logintoyourAccount = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue("login yazisi gozukmedi", logintoyourAccount.isDisplayed());
        //  6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]"));
        email.sendKeys("maslan11alp@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("04101985");
        //  7. Click 'login' button
        WebElement loginButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        loginButton.click();
        //  8. Verify that 'Logged in as username' is visible
        WebElement loggedInUsername = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue("logged in gozukmuyor", loggedInUsername.isDisplayed());
        System.out.println("kullanici adi yazisi " + loggedInUsername.getText());
        //  9. Click 'Delete Account' button
        WebElement deleteButton = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteButton.click();
        //  10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDeleted = driver.findElement(By.tagName("h1"));
        Assert.assertTrue("acount deleted gözükmedi", accountDeleted.isDisplayed());
    }


    }

