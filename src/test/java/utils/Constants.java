package utils;

public class Constants {

    public  static final String CONFIGURATION_FILEPATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
                                                        //it will return us executing    // it will return us local
                                                        // machine path                 // this project location
                                                                //so our cod will work in every single machine

    public static final String TESTDATA_FILEPATH = System.getProperty("user.dir")+"/src/test/resources/testdata/hrmsdatabatch10.xlsx";
    public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir")+"/screenshots/";
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 20; // -> wait maximum 20 seconds till element will be able to click or choose


}
