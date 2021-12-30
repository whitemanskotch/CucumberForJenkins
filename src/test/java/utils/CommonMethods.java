package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static WebDriver driver;


    public void openBrowser(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case"chrome":
            //    System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver.exe");

                //we are checking for a properties
                if(ConfigReader.getPropertyValue("headless").equals("true")){
                    //we write this piece of code and pass chromeOptions to the webdriver: driver = new ChromeDriver(chromeOptions);
                    //to get all the testing will be done behind the seeing
                    // to make it work (for jenkins)
                    ChromeOptions chromeOptions= new ChromeOptions();
                    chromeOptions.setHeadless(true);

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                } else{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
     //   driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
                return wait;
    }

    public static void waitForClickablity(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){

        element.click();
    }

    public static JavascriptExecutor getJSWExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSWExecutor().executeScript("arguments[0].click();", element);
    }

    //class 4 methods
    //to take screenshot
    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;

        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,new File(Constants.SCREENSHOT_FILEPATH+fileName+" "+getTimeSteam("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  picBytes;
    }

    public static String getTimeSteam(String pattern){
        Date date = new Date();
        //YYYY-MM-DD-HH-MM-SS-MS
        //to farmat the date according to our choice we have a function
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    public void tearDown(){
        driver.quit();
    }
}
