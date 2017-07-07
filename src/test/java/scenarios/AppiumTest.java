package scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AppiumTest extends AndroidSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    /*@Test(priority=1)
    public void test01() throws InterruptedException {
        new LoginPage(driver).invalidLogin();
    }*/

    @Test(priority=2)
    public void test02Camera() throws InterruptedException {
        new LoginPage(driver).test02Camera();
    }

    @Test(priority=3)
    public void test03Password() throws InterruptedException {
        new LoginPage(driver).test03Password();
    }

    @Test(priority=3)
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
    }

}
