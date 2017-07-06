package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    //By root = By.id("root");
    //By go = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup[4]");
    //By drawercontent = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.view.ViewGroup[1]");
    /*By login_Button = By.id("btn_mlogin");
    By existingUser_login = By.id("btn_mlogin");*/

    By btn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage invalidLogin() throws InterruptedException {
        waitForVisibilityOf(btn);
        driver.findElement(btn).click();
        /*AndroidDriver d = (AndroidDriver) driver;
        d.swipe(4, 0, 400, 0, 1000);
        Thread.sleep(500);
        d.swipe(400, 0, 4, 0, 1000);
        Thread.sleep(500);
        Assert.assertNotNull(driver.findElement(drawercontent));
        d.swipe(100, 350, 100, 600, 1000);
        //TouchAction t = new TouchAction(driver);
        //swipeRightToLeft();
        /*driver.findElement(userId).clear();
        driver.findElement(userId).sendKeys("someone@testvagrant.com");
        driver.findElement(password).sendKeys("testvagrant123");
        driver.findElement(login_Button).click();
        Assert.assertTrue(driver.findElement(By.id("pageLevelError")).getText().equalsIgnoreCase("Account does not exist"));*/
        return new LoginPage(driver);
    }
}