package ui.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui.pages.HomePage;
import ui.pages.LoginPage;
import ui.utils.ConfigReader;
import ui.utils.DriverUtils;

public class LoginPageStepDefs {

    WebDriver driver = DriverUtils.getDriver();
    LoginPage loginPage;
    HomePage homePage;

    @Given("I am on OrangeHrm login page")
    public void i_am_on_orange_hrm_login_page() {
        driver.get(ConfigReader.readProperty("url"));
    }
    @When("I fill up all info for login")
    public void i_fill_up_all_info_for_login() {
        loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
    }
    @Then("I see dashboard page")
    public void i_see_dashboard_page() {
        homePage = new HomePage(driver);
        Assert.assertEquals("Dashboard", homePage.getDashboardText());
    }
    @When("I fill up all info with invalid credentials")
    public void i_fill_up_all_info_with_invalid_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("invusername"),ConfigReader.readProperty("invpassword"));
    }
    @Then("I see error message")
    public void i_see_error_message() {
        loginPage = new LoginPage(driver);
        Assert.assertEquals("Invalid credentials", loginPage.getErrorText());
    }


}
