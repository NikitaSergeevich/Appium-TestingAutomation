package setup;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegistrationFlow;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class AppiumTest extends AndroidSetup {

    List<Integer> password = new ArrayList<Integer>(){{
        add(1);
        add(1);
        add(1);
        add(1);
    }};
    String phone = new String ("9991643734");
    RegistrationFlow r;

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        r = new RegistrationFlow(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test(priority=2)
    public void RegistrationPhoneConfirm() throws InterruptedException {
        r.PhoneInputPositive(phone);
        r.SMSCodeInputPositive();
    }

    @Test(priority=3)
    public void RegistrationPassword01() throws InterruptedException {
        r.PasswordConfirmNegative();
        this.password = r.PasswordConfirmPositive();
    }

    @Test(priority=4)
    public void RegistrationPassword02() throws InterruptedException {
        driver.resetApp();
        r.PhoneInputPositive(phone);
        r.SMSCodeInputPositive();
        r.PasswordInputPositive(password);
    }

    @Test(priority=5)
    public void RegistrationCamera() throws InterruptedException {
        r.CameraConfirm();
    }

    @Test(priority=6)
    public void LoginFlow() throws InterruptedException {
        driver.resetApp();
        r.PhoneInputPositive(phone);
        r.SMSCodeInputPositive();
        r.PasswordInputPositive(password);
        r.CameraConfirm();
    }

    @Test(priority=7)
    public void Dashboard() throws InterruptedException {

    }


    /*@Test(priority=3)
    public void test04Password() throws InterruptedException {
        new LoginPage(driver).test04Password();
    }

    @Test(priority=5)
    public void test05Password() throws InterruptedException {
        new LoginPage(driver).test05Password();
    }

    @Test(priority = 6)
    public void test06Password() throws InterruptedException {
        new LoginPage(driver).test06PhoneNumber();
    } */

}
