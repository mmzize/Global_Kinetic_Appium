package Tests;

import Setup.Setup_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Execute_Tests extends Setup_Class {

    By Menu_Genres = By.id("com.instantappsample.uamp:id/title");
    By Genre = By.id("com.instantappsample.uamp:id/title");
    By Song=  By.xpath("//android.widget.TextView[@text='Drop and Roll']");
    By Pause =By.id("com.instantappsample.uamp:id/play_pause");

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

}
