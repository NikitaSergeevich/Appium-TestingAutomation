package setup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidSetup {
    protected AndroidDriver driver;
    protected void prepareAndroidForAppium() throws MalformedURLException {
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        //Use a higher value if your mobile elements take time to show up
        File appDir = new File("/Users/a2/Documents/humaniq-android-lite/app/build/outputs/apk/");
        File app = new File(appDir, "app-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability("noReset",false);
        capabilities.setCapability("platformVersion", "4.4.4");
        //mandatory capabilities
        capabilities.setCapability("deviceName","Samsung Galaxy S3 API 25");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("autoGrantPermissions", true);

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    }
}
