package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nikita on 27.06.2017.
 */
public class AndroidSetup {
    protected AndroidDriver driver;
    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("D:/Projects/RN Projects/TaxiApp/android/app/build/outputs/apk");
        File app = new File(appDir, "app-release.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("platformVersion", "7.1.1");
        //mandatory capabilities
        capabilities.setCapability("deviceName","Samsung Galaxy S3 API 25");
        capabilities.setCapability("platformName","Android");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}