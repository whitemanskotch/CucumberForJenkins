package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;
    //this method will read any of all property file
    public static void readProperties (String filePath){
        try {
            FileInputStream fis = new FileInputStream(filePath);
             prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //this method retrieves single value based on the specified key
    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }

}
