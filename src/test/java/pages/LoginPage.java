package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    // Common elements
    By btn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]");
    By gonext_btn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]");
    By tutorialtitle = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.TextView");

    // Camera special elements
    By takefoto = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[3]/android.view.View");
    By btntextelement = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[3]/android.widget.TextView");
    By alerttitle = By.id("android:id/alertTitle");
    By alertbutton = By.id("android:id/button1");

    // Password special elements
    By keyboard1 = MobileBy.AccessibilityId("1");
    By keyboard2 = MobileBy.AccessibilityId("2");
    By keyboard3 = MobileBy.AccessibilityId("3");
    By keyboard4 = MobileBy.AccessibilityId("4");
    By keyboard5 = MobileBy.AccessibilityId("5");
    By keyboard6 = MobileBy.AccessibilityId("6");
    By keyboard7 = MobileBy.AccessibilityId("7");
    By keyboard8 = MobileBy.AccessibilityId("8");
    By keyboard9 = MobileBy.AccessibilityId("9");
    By keyboard0 = MobileBy.AccessibilityId("0");

    By keyboardback = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[9]/android.view.View[3]");
    By buttonenabledtext = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.widget.TextView");
    By helpbutton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[9]/android.view.View[1]");
    By helpalertmessage = By.id("android:id/message");

    // Phone Input special elements
    By buttonenabledphonetext = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage test01Camera() throws InterruptedException {
        // Press new button
        waitForVisibilityOf(btn);
        Assert.assertTrue(driver.findElement(tutorialtitle).getText().equalsIgnoreCase("tutorial for Password"));
        driver.findElement(btn).click();
        driver.findElement(gonext_btn).click();
        return new LoginPage(driver);
    }

    public LoginPage test02Camera() throws InterruptedException {
        waitForVisibilityOf(btn);

        // Check if we are on camera screen
        Assert.assertTrue(driver.findElement(tutorialtitle).getText().equalsIgnoreCase("tutorial for Camera"));
        // Сlick on button in center of screen.
        driver.findElement(btn).click();
        Thread.sleep(500);
        // Сlick on button in bottom of screen.
        driver.findElement(gonext_btn).click();
        Thread.sleep(1000);
        // Take photo without face (click on button at the bottom).
        driver.findElement(takefoto).click();
        Thread.sleep(1000);
        // Upload photo (click on button at the bottom).
        driver.findElement(takefoto).click();
        // Check that next screen is shown with text "Tutorial for Password"
        Assert.assertTrue(driver.findElement(btntextelement).getText().equalsIgnoreCase("Uploading"));
        waitForVisibilityOf(btn);
        Assert.assertTrue(driver.findElement(tutorialtitle).getText().equalsIgnoreCase("tutorial for Password"));

        return new LoginPage(driver);
    }

    public LoginPage test03Password() throws InterruptedException {
        waitForVisibilityOf(btn);

        // Check if we are on password screen
        Assert.assertTrue(driver.findElement(tutorialtitle).getText().equalsIgnoreCase("tutorial for Password"));

        // Skip tutorial and press help button
        driver.findElement(btn).click();
        driver.findElement(gonext_btn).click();
        waitForVisibilityOf(helpbutton);
        driver.findElement(helpbutton).click();

        // Check if alert will show
        waitForVisibilityOf(helpalertmessage);
        // Close
        driver.findElement(alertbutton).click();

        return new LoginPage(driver);
    }

    public LoginPage test04Password() throws InterruptedException {
        // Press 3 keyboard buttons
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard1).click();

        // Check if button is not enabled
        Assert.assertTrue(driver.findElements(buttonenabledtext).isEmpty());

        // Clean all numbers
        driver.findElement(keyboardback).click();
        driver.findElement(keyboardback).click();
        driver.findElement(keyboardback).click();
        driver.findElement(keyboardback).click();

        return new LoginPage(driver);
    }

    public LoginPage test05Password() throws InterruptedException {
        // Enter 4 numbers
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard1).click();
        driver.findElement(buttonenabledtext).click();

        // Enter 4 another numbers (not same)
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard2).click();

        // Check if button is not enabled
        Assert.assertTrue(driver.findElements(buttonenabledtext).isEmpty());

        // Clean all numbers
        driver.findElement(keyboardback).click();
        driver.findElement(keyboardback).click();
        driver.findElement(keyboardback).click();
        driver.findElement(keyboardback).click();

        // Enter 4 another numbers (same)
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard1).click();

        driver.findElement(buttonenabledtext).click();

        // Check if we are on next screen
        waitForVisibilityOf(btn);

        return new LoginPage(driver);
    }

    public LoginPage test06PhoneNumber() throws InterruptedException {
        waitForVisibilityOf(btn);// Check if we are on password screen
        Assert.assertTrue(driver.findElement(tutorialtitle).getText().equalsIgnoreCase("tutorial for TelInput"));
        driver.findElement(btn).click();
        driver.findElement(gonext_btn).click();
        inputNumber();
        waitForVisibilityOf(buttonenabledphonetext);
        driver.findElement(buttonenabledphonetext).click();
        return new LoginPage(driver);
    }

    public void inputNumber() throws InterruptedException {
        driver.findElement(keyboard7).click();
        driver.findElement(keyboard9).click();
        driver.findElement(keyboard9).click();
        driver.findElement(keyboard9).click();
        driver.findElement(keyboard1).click();
        driver.findElement(keyboard6).click();
        driver.findElement(keyboard4).click();
        driver.findElement(keyboard3).click();
        driver.findElement(keyboard7).click();
        driver.findElement(keyboard3).click();
        driver.findElement(keyboard4).click();
    }
}