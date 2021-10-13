package Tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Test_Runner {

    private AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    //////////Elements///////////////////
    By Menu_Genres = By.id("com.instantappsample.uamp:id/title");
    By Genre = By.id("com.instantappsample.uamp:id/title");
    By Song=  By.xpath("//android.widget.TextView[@text='Drop and Roll']");
    By Pause =By.id("com.instantappsample.uamp:id/play_pause");

    @BeforeSuite()
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel XL API 30");
        caps.setCapability("udid", "ROWM707GEDJ"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.instantappsample.uamp");
        caps.setCapability("appActivity", "com.example.android.uamp.ui.MusicPlayerActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void Select_Menu_Item_Test()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Menu_Genres)).click();
    }
    @Test (priority = 1)
    public void Select_Genre_Test()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Genre)).click();
    }
    @Test (priority = 2)
    public void Play_Drop_And_Roll_Song_Test() {

      wait.until(ExpectedConditions.visibilityOfElementLocated(Song)).click();
    }
    @Test(priority = 3)
    public void Pause_The_Music()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Pause)).click();
    }
    @AfterSuite
    public void Quit_Test()
    {
        driver.quit();
    }
}