package com.alten.testsigma.addons.android;

import com.testsigma.sdk.AndroidAction;
import com.testsigma.sdk.ApplicationType;
import com.testsigma.sdk.Result;
import com.testsigma.sdk.annotation.Action;
import com.testsigma.sdk.annotation.Element;
import com.testsigma.sdk.annotation.TestData;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Action(actionText = "Disable geolocation",
        applicationType = ApplicationType.ANDROID,
        useCustomScreenshot = false)
public class DisableGeo extends AndroidAction {
  @Override
  public com.testsigma.sdk.Result execute() throws NoSuchElementException {
    com.testsigma.sdk.Result result = null;
    String command= "adb shell settings put secure location_mode 0";
    try {
      // Esegui il comando adb
      Process process = Runtime.getRuntime().exec(command);
      setSuccessMessage("Geolocation DISABLED");
      result = Result.SUCCESS;
    } catch (IOException e) {
      e.printStackTrace();
      setErrorMessage("ERROR Exception: "+e);
      result = Result.FAILED;
    }
    return result;
  }
}
