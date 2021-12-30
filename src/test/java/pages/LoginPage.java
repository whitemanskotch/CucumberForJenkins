package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(id="txtUsername")
    public WebElement usernameBox;

    @FindBy(id = "txtPassword")
    public WebElement passwordBox;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;




    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    /* OTHER METHOD to call the driver:
            if we don't do extends-> public class LoginPage extends CommonMethods {  ->(if we do without extends-> public class LoginPage {  'in line 9') -> ,we can do:
    LoginPage(WebDriver driver){
    PageFactory.initElements(driver, this);
            but its can give as a problems with reading
     */

    public void login(String username, String password){
        sendText(usernameBox, username);
        sendText(passwordBox, password);
        click(loginBtn);
    }


}
