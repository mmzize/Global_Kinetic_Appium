package Setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class Setup_Class {

    AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    @BeforeSuite
    public void Setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel XL API 30");
        caps.setCapability("udid", "ROWM707GEDJ"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.instantappsample.uamp");
        caps.setCapability("appActivity", "com.example.android.uamp.ui.MusicPlayerActivity");
        caps.setCapability("noReset", "false");

        URL url =new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AppiumDriver<MobileElement>(url,caps);
        wait = new WebDriverWait(driver, 10);
    }
    @AfterSuite
    public void Quit_Test()
    {
        driver.quit();
    }
}
