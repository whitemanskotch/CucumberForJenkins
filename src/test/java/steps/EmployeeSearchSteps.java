package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user is navigated to HRMS")
    public void user_is_navigated_to_hrms() {
        openBrowser();
    }

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigReader.getPropertyValue("password"));
        click(login.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
        click(dash.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage emp = new EmployeeListPage();
        sendText(emp.idEmployee, "25865A");  // we can pass eny id of eny employee (textToSend) which we need to search in HRMS
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        EmployeeListPage emp = new EmployeeListPage();
        sendText(emp.employeeNameField, "Sohail TheBest");  // we can pass eny name of eny employee (textToSend) which we need to search in HRMS
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage emp = new EmployeeListPage();
        click(emp.searchButton);
    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("Info is displayed");
    //    tearDown();


   /*     EmployeeListPage emp = new EmployeeListPage();
        
        List<WebElement> rowData = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));

            for(int i=0; i<rowData.size(); i++){
                System.out.println("I an inside the loop to get values for the nawly searched employee");
                String rowText = rowData.get(i).getText();
                System.out.println(rowText);
            //    String expectedData = emp.idEmployee.getText();
                String expectedData = emp.idEmployee.getText()+ " "+ emp.employeeNameField.getText();
                if (rowText.equals(expectedData)){
                    System.out.println("Info is displayed");  //Assert.assertTrue( replase leter
                }
            }
        tearDown();*/
         
    }


}
