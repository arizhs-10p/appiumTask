import configurationFileReader.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {


    public static void main(String[] args) {


    }
    ConfigReader configReader = new ConfigReader();

   // ConfigReader configReader;
//    public FirstAndroidTest()
//    {
//        ConfigReader configReader;
//        configReader = new ConfigReader();
//    }

    AppiumDriver driver;



//    @BeforeTest
//    public void initializer() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "8.1.0");
//        capabilities.setCapability("deviceName", "emulator-5554");
//        capabilities.setCapability("automationName", "Appium");
//        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos.apk");
//        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
//        System.out.println("Opening appium server");
//    }
@BeforeTest
    public void initializer() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", configReader.getPlatformName());
        capabilities.setCapability("platformVersion",configReader.getPlatformVersion());
        capabilities.setCapability("deviceName",configReader.getDeviceName());
        capabilities.setCapability("automationName",configReader.getAutomationName());
        capabilities.setCapability("app", System.getProperty("user.dir") + configReader.getApkPath());
        driver = new AndroidDriver(new URL(configReader.appiumServerEndpointURL()), capabilities);
        System.out.println("Opening appium server");
    }

    @Test
    public void sampleTest() throws InterruptedException {
        System.out.println("test");
        //Thread.sleep(Long.parseLong("5000"));
        //driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
    }

    @AfterTest
    public void tearDown(){
        if (null != driver)
        {
            driver.quit();
        }

    }
}


