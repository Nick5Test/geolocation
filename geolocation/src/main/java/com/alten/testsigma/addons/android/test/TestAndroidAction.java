package com.alten.testsigma.addons.android.test;


import com.alten.testsigma.addons.android.DisableGeo;
import com.alten.testsigma.addons.android.EnableGeo;
import com.alten.testsigma.addons.android.SwipeOnScreen;

import com.google.common.collect.ImmutableMap;
import com.testsigma.sdk.TestData;
import com.testsigma.sdk.runners.ActionRunner;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;;

public class TestAndroidAction {
    private ActionRunner runner;
    private AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        // Make sure to start Appium server
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("app", "C:\\NexiPay\\NEXIPay_7.9.1-mock-debugDexguard.apk");
        caps.setCapability("deviceName", "samsung-sm_g991b-R5CR92NRVNP");
        caps.setCapability("udid", "R5CR92NRVNP");
        caps.setCapability("platformName", "ANDROID");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        caps.setCapability("noReset","true");
        caps.setCapability("fullReset","false");
        caps.setCapability("appPackage", "it.icbpi.mobile"); // Sostituisci con il pacchetto dell'app  it.icbpi.mobile
        caps.setCapability("appActivity", "it.icbpi.mobile.feature.launchmode.LaunchModeActivity");
        caps.setCapability("relaxedSecurity", true);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        runner = new ActionRunner(driver);

    }

    @Test
    public void Test() throws Exception {
        //DisableGeo action = new DisableGeo();
        EnableGeo action = new EnableGeo();
        runner.run(action);
    }

    @AfterClass
    public void teardown() {
        if (runner != null) {
            runner.quit();
        }
    }
}
