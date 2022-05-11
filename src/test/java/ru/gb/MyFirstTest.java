package ru.gb;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstTest {

    @Test
    public void CheckEmptyEmail() throws MalformedURLException, InterruptedException {
//        openApp().
//                clickMenuLogin().
//                setEmptyLoginText().
//                checkValidErrorMessageAboutLogin();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("app", "C:/Users/Natalie/Android-NativeDemoApp-0.2.1.apk");
        capabilities.setCapability("appium:automationName", "UIAutomation2");

        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        Thread.sleep(2000);
        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("//android.view.ViewGroup[@content-desc=\"Login\"]/android.widget.TextView");
        loginMenuButton.click();
        Thread.sleep(2000);
        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup");
        loginButton.click();
        Thread.sleep(2000);
        MobileElement errorText = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView[1]");

        Assert.assertEquals(errorText.getText(), "Please enter a valid email address");
        driver.quit();
    }
}
