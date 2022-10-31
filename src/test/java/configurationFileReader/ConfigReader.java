package configurationFileReader;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
       // this.properties = properties;
        BufferedReader reader;
        String propertyFilePath = "configuration//Config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }

    }

//    public ConfigReader() {
//
//    }

    //Name
    public String getPlatformName()
    {
        String platformName = properties.getProperty("platformName");
        if (platformName != null) return platformName;
        else throw new RuntimeException("Platform name Not specified in the config file");
    }
    //Version
    public String getPlatformVersion()
    {
        String platformVersion = properties.getProperty("platformVersion");
        if (platformVersion != null) return platformVersion;
        else throw new RuntimeException("Platform Version Not specified in the config file");
    }

    public String getDeviceName()
    {
        String deviceName = properties.getProperty("deviceName");
        if (deviceName != null) return deviceName;
        else throw new RuntimeException("Device name Not specified in the config file");
    }

    public String getAutomationName()
    {
        String automationName = properties.getProperty("automationName");
        if (automationName != null) return automationName;
        else throw new RuntimeException("Automation name not specified in the config file");
    }
    public String getApkPath()
    {
        String apkPath = properties.getProperty("apkPath");
        if (apkPath != null) return apkPath;
        else throw new RuntimeException("Automation name not specified in the config file");
    }
    public String appiumServerEndpointURL()
    {
        String appiumServerEndpointURL = properties.getProperty("appiumServerEndpointURL");
        if (appiumServerEndpointURL != null) return appiumServerEndpointURL;
        else throw new RuntimeException("Automation name not specified in the config file");
    }


}

