package com.firsttestios;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomationIOSTest {
@Test
    public void firstTest() throws MalformedURLException, InterruptedException {
    URL serverURL = new URL("http://0.0.0.0:4723/wd/hub");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"14.6");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone XR");
    capabilities.setCapability(MobileCapabilityType.UDID,"00008020-00110D1A1109002E");
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Safari");
    capabilities.setCapability("showXcodeLog","true");
    capabilities.setCapability("autoAcceptAlerts","true");

    AppiumDriver driver = new IOSDriver(serverURL,capabilities);
    WebDriverWait wait = new WebDriverWait(driver,30);
    Thread.sleep(5000);
    driver.get("https://github.com/");
}
}
