package pages;

import com.oracle.tools.packager.Log;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.appium.java_client.MobileBy;

import java.util.Random;

public class RegistrationFlow extends BasePage {

    public RegistrationFlow(WebDriver driver) {
        super(driver);
    }

    List<Integer> password = new ArrayList<Integer>();

    public void skipTutorial() {
        //- Check that "Camera Tutorial" screen is shown.
        //- Enable GPS.
        MobileElement el1 = waitForVisibilityOf(By.id("android:id/button1"), 1);
        if (el1 != null) {
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[1]/android.view.View/android.widget.Switch"));
            el2.click();
            driver.navigate().back();
        }
        // Сlick on "Bottom" button
        MobileElement continueStep = waitForVisibilityOf(By.id("com.humaniq.lite:id/continue_step"), 10);
        Assert.assertNotEquals(continueStep, null);
        continueStep.click();
    }

    public void PhoneInputPositive(String phone) {

        // Check "Phone Input" screen is displayed.
        MobileElement submitButton = waitForVisibilityOf(By.id("com.humaniq.lite:id/submitButton"), 10);
        Assert.assertNotEquals(submitButton, null);

        // Click on country-code button
        MobileElement countryCode = (MobileElement) driver.findElement(By.id("com.humaniq.lite:id/code"));
        countryCode.click();

        // Click on search button
        MobileElement searchButton = (MobileElement) driver.findElement(By.id("com.humaniq.lite:id/action_search"));
        searchButton.click();

        MobileElement searchSrcText = (MobileElement) driver.findElement(By.id("com.humaniq.lite:id/search_src_text"));

        // Enter country name "Russia"
        searchSrcText.sendKeys("Russia");

        // Click on country in list
        MobileElement country = (MobileElement) driver.findElement(By.id("com.humaniq.lite:id/flag"));
        country.click();

        // Enter correct phone number
        MobileElement phoneInput = (MobileElement) driver.findElement(By.id("com.humaniq.lite:id/phone_input"));
        phoneInput.sendKeys(phone);

        // Press upper-keyboard button
        submitButton.click();

        //- Check that SMS code screen is shown
        MobileElement requestSms = waitForVisibilityOf(By.id("com.humaniq.lite:id/request_sms"), 10);

        Assert.assertNotEquals(requestSms, null);
    }

    // TODO Incorrect phonenumber

    public void SMSCodeInputPositive() throws InterruptedException {
        //Find field to input and set SMS CODE
        waitForVisibilityOf(By.id("com.humaniq.lite:id/passcode"), 50);
    }

    public void PasswordConfirmNegative() throws InterruptedException {
        waitForVisibilityOf(By.id("com.humaniq.lite:id/passcode"), 20);
        Thread.sleep(3000);

        Random randomGenerator = new Random();
        for (int x = 0; x < 4; x = x + 1) {
            Integer num = randomGenerator.nextInt(10);
            num = 1;
            password.add(num);
            MobileElement key = (MobileElement) driver.findElement(By.id(this.getKeyBoardButton(num)));
            key.click();
            Thread.sleep(1000);
        }

        Thread.sleep(3000);
        for (int x = 0; x < 4; x = x + 1) {
            int num = password.get(x);
            if (num < 9) {
                num = num + 1;
            }
            MobileElement key = (MobileElement) driver.findElement(By.id(this.getKeyBoardButton(num)));
            key.click();
            Thread.sleep(1000);
        }
    }

    public List<Integer> PasswordConfirmPositive() throws InterruptedException {
        waitForVisibilityOf(By.id("com.humaniq.lite:id/passcode"), 20);
        Random randomGenerator = new Random();
        password = new ArrayList<Integer>();
        Thread.sleep(4000);
        for (int x = 0; x < 4; x = x + 1) {
            Integer num = randomGenerator.nextInt(10);
            num = 1;
            password.add(num);
            MobileElement key = (MobileElement) driver.findElement(By.id(this.getKeyBoardButton(num)));
            key.click();
            Thread.sleep(1000);
        }

        Thread.sleep(4000);
        for (int x = 0; x < 4; x = x + 1) {
            int num = password.get(x);
            MobileElement key = (MobileElement) driver.findElement(By.id(this.getKeyBoardButton(num)));
            key.click();
            Thread.sleep(1000);
        }

        Thread.sleep(2000);

        MobileElement preview = waitForVisibilityOf(By.id("com.humaniq.lite:id/preview"), 50);
        Assert.assertNotEquals(preview, null);
        return password;
    }

    public void PasswordInputPositive(List<Integer> password) throws InterruptedException {
        waitForVisibilityOf(By.id("com.humaniq.lite:id/passcode"), 20);
        Random randomGenerator = new Random();
        Thread.sleep(4000);
        for (int x = 0; x < 4; x = x + 1) {
            Integer num = password.get(x);
            MobileElement key = (MobileElement) driver.findElement(By.id(this.getKeyBoardButton(num)));
            key.click();
            Thread.sleep(1000);
        }
        Thread.sleep(2000);

        MobileElement preview = waitForVisibilityOf(By.id("com.humaniq.lite:id/preview"), 10);
    }

    public void LoginPasswordInputPositive(List<Integer> password) throws InterruptedException {
        waitForVisibilityOf(By.id("com.humaniq.lite:id/passcode"), 20);
        Random randomGenerator = new Random();
        Thread.sleep(4000);
        for (int x = 0; x < 4; x = x + 1) {
            Integer num = password.get(x);
            MobileElement key = (MobileElement) driver.findElement(By.id(this.getKeyBoardButton(num)));
            key.click();
            Thread.sleep(1000);
        }
        Thread.sleep(2000);

        MobileElement transactionsRecycler = waitForVisibilityOf(By.id("com.humaniq.lite:id/transactions_recycler"), 10);
        Assert.assertNotEquals(transactionsRecycler, null);
    }

    public void CameraConfirm() throws InterruptedException {
        MobileElement confirm = waitForVisibilityOf(By.id("com.humaniq.lite:id/confirm"), 20);
        Assert.assertNotEquals(confirm, null);
        confirm.click();

        MobileElement repeat = waitForVisibilityOf(By.id("com.humaniq.lite:id/repeat"), 60);
        Assert.assertNotEquals(repeat, null);
        confirm.click();


        MobileElement transactionRecycler = null;

        while (transactionRecycler == null) {
            transactionRecycler = waitForVisibilityOf(By.id("com.humaniq.lite:id/transactions_recycler"), 20);
            if (transactionRecycler == null) {
                repeat.click();
                Thread.sleep(2000);
                confirm.click();
            }
        }
    }

    private String getKeyBoardButton(int num) {
        String postfix = new String();
        String prefix = new String("com.humaniq.lite:id/");
        switch (num) {
            case 1:
                postfix = "one";
                break;
            case 2:
                postfix = "two";
                break;
            case 3:
                postfix = "three";
                break;
            case 4:
                postfix = "four";
                break;
            case 5:
                postfix = "five";
                break;
            case 6:
                postfix = "six";
                break;
            case 7:
                postfix = "seven";
                break;
            case 8:
                postfix = "eight";
                break;
            case 9:
                postfix = "nine";
                break;
            case 0:
                postfix = "zero";
                break;
            default:
                postfix = "one";
                break;
        }

        prefix = prefix.concat(postfix);
        return prefix;
    }




//    public void test05Password() throws InterruptedException {
//        // Enter 4 numbers
//        driver.findElement(keyboard1).click();
//        driver.findElement(keyboard1).click();
//        driver.findElement(keyboard1).click();
//        driver.findElement(keyboard1).click();
//        driver.findElement(buttonenabledtext).click();
//
//        // Enter 4 another numbers (not same)
//        driver.findElement(keyboard1).click();
//        driver.findElement(keyboard1).click();
//        driver.findElement(keyboard1).click();
//        driver.findElement(keyboard2).click();
//
//        // Check if button is not enabled
//        Assert.assertTrue(driver.findElements(buttonenabledtext).isEmpty());
//
//        // Clean all numbers
//        driver.findElement(keyboardback).click();
//        driver.findElement(keyboardback).click();
//        driver.findElement(keyboardback).click();
//        driver.findElement(keyboardback).click();
//
//        // Enter 4 another numbers (same)
//        driver.findElement(keyboard1).click();
//        driver.findElement(keyboard1).click();
//        driver.findElement(keyboard1).click();
//        driver.findElement(keyboard1).click();
//
//        driver.findElement(buttonenabledtext).click();
//
//        // Check if we are on next screen
//        waitForVisibilityOf(btn);
//
//        return new LoginPage(driver);
//    }

//    public void test06PhoneNumber() throws InterruptedException {
////        waitForVisibilityOf(btn);// Check if we are on password screen
////        Assert.assertTrue(driver.findElement(tutorialtitle).getText().equalsIgnoreCase("tutorial for TelInput"));
////        driver.findElement(btn).click();
////        driver.findElement(gonext_btn).click();
////        inputNumber();
////        waitForVisibilityOf(buttonenabledphonetext);
////        driver.findElement(buttonenabledphonetext).click();
////        return new LoginPage(driver);
//    }

//    public void inputNumber() throws InterruptedException {
//        driver.findElement(keyboard7).click();
//        driver.findElement(keyboard9).click();
//        driver.findElement(keyboard9).click();
//        driver.findElement(keyboard9).click();
//        driver.findElement(keyboard1).click();
//        driver.findElement(keyboard6).click();
//        driver.findElement(keyboard4).click();
//        driver.findElement(keyboard3).click();
//        driver.findElement(keyboard7).click();
//        driver.findElement(keyboard3).click();
//        driver.findElement(keyboard4).click();
//    }
}
