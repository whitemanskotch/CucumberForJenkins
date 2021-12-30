package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",

        //glue is where we can find the implementation for gherkin steps
        //here we provide the path of our steps package
        glue = "steps",
        //if we set dryRun to true  (dryRun = true), then no actual execution happens
        // it will quickly scan all gherkin steps whether they have implementation or not
        //if we wanna execute our cod , we need to set  dryRun to false (dryRun = false)
        dryRun = false,
        //it keeps the console output for the cucumber test easily readable
        //it will remove all unreadable character
        monochrome = true,
        //when we pass tags and "or" between them (tags="@smoke or @sprint1") it is givs as output where is avelieble one or other scenario
        // when we pass tags and "and" betweem them (tags="@smoke and @sprint1") it is givs as output only whose scenarios where is both aveleble
        tags="@error",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/failed.txt"}
        //plugin - we use it to generate report for the execution
        //pretty - it takes care of printing the steps in console
       // strict=true, -> it checks all the steps definition
)

public class Smoke {
}
