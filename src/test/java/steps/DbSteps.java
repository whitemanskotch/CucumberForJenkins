package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.DBUtils;
import utils.GlobalVariables;

import java.util.List;
import java.util.Map;

public class DbSteps {

    @Then("query HRMS database")
    public void query_hrms_database_and_get_data() {

        GlobalVariables.mapDataFromDb=DBUtils.mapFromDb("SELECT emp_firstname, emp_middle_name, emp_lastname "
                + "FROM hs_hr_employees "
                + "WHERE employee_id="+GlobalVariables.empId);
    }

}
