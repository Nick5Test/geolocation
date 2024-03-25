package com.alten.testsigma.addons.ios;


import com.testsigma.sdk.ApplicationType;
import com.testsigma.sdk.IOSAction;
import com.testsigma.sdk.Result;
import com.testsigma.sdk.annotation.Action;
import io.appium.java_client.ios.IOSDriver;
import lombok.Data;
import org.openqa.selenium.NoSuchElementException;

@Data
@Action(actionText = "Lauch Settings",
        applicationType = ApplicationType.IOS,
        useCustomScreenshot = false)
public class LauchSettings extends IOSAction {

  @Override
  protected com.testsigma.sdk.Result execute() throws NoSuchElementException {
    //Your Awesome code starts here
    com.testsigma.sdk.Result result = null;
    IOSDriver iosDriver = (IOSDriver)this.driver;
    iosDriver.activateApp("com.apple.Preferences");
    result = Result.SUCCESS;
    return result;
  }
}