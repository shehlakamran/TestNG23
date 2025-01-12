package Ninga.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;

    @Parameters("url")
    @BeforeMethod
    public void setup(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo");

    }

    @AfterMethod
    public void closure() {
        driver.quit();
    }

    @Test(priority = 1)
    public void loginWithValidCredentials() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
        driver.findElement(By.id("input-email")).sendKeys("shehlastudy@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("raZia223Sultana");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }

    @Test(priority = 2)
    public void loginWithValidusernmeandInvalidpassword() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
        driver.findElement(By.id("input-email")).sendKeys("shehlastudy@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("raZia224Sultana");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), "Warning: No match for E-Mail Address and/or Password.\n");

    }

    @Test(priority = 4)
    public void loginWithInvalidsusernameandValidpassword() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
        driver.findElement(By.id("input-email")).sendKeys("shehlasstudy@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("raZia224Sultana");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), "Warning: No match for E-Mail Address and/or Password.\n");

    }

}

