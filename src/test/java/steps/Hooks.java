package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void start(){
        openBrowser();
    }

    @After
    public void end(Scenario scenario){
        byte[]pic;
        if(scenario.isFailed()){
            pic = takeScreenshot("failed/" + scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }
        //it will attach pics in report
        scenario.attach(pic, "image/png", scenario.getName());
        tearDown();
    }
}
