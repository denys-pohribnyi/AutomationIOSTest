package com.firsttestios;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

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
    WebDriverWait wait = new WebDriverWait(driver,5);
    driver.get("https://saucedemo.com/");

    WebElement userNameField = driver.findElement(By.name("user-name"));
    userNameField.sendKeys("standard_user");

    WebElement userPasswordField = driver.findElement(By.name("password"));
    userPasswordField.sendKeys("secret_sauce");

    WebElement loginButton = driver.findElement(By.id("login-button"));
    loginButton.click();

    WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));

       JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
    HashMap<String, String> scrollToObject = new HashMap<String, String>();
    scrollToObject.put("direction", "down");
    scrollDown.executeScript("mobile: scroll",scrollToObject);
    addToCart.click();
    cartLink.click();

    WebElement checkout = driver.findElement(By.id("checkout"));
    checkout.click();

    WebElement checkoutName = driver.findElement(By.id("first-name"));
    WebElement checkoutLastName = driver.findElement(By.id("last-name"));
    WebElement checkoutPostalCode = driver.findElement(By.id("postal-code"));
    WebElement checkoutNext = driver.findElement(By.id("continue"));

    checkoutName.sendKeys("Ivan");
    checkoutLastName.sendKeys("Ivanov");
    checkoutPostalCode.sendKeys("18000");
    Thread.sleep(3000);
    checkoutNext.click();
    WebElement finishBtn = driver.findElement(By.id("finish"));
    finishBtn.click();
    Thread.sleep(3000);
    driver.quit();

    //WebElement slide = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    //slide.sendKeys("0.5");

}

}
