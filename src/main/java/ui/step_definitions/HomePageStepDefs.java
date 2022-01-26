package ui.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui.pages.AdminPage;
import ui.pages.HomePage;

import ui.pages.LoginPage;
import ui.utils.ConfigReader;
import ui.utils.DriverUtils;


public class HomePageStepDefs {

    WebDriver driver = DriverUtils.getDriver();
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;

    @Given("I am on OrangeHrm home page")
    public void i_am_on_orange_hrm_home_page() {
        driver.get(ConfigReader.readProperty("url"));
        loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
    }

    @When("I click the Admin button")
    public void i_click_the_admin_button() {
        homePage = new HomePage(driver);
        homePage.clickAdminButton();
    }

    @When("I should see System Users header")
    public void i_should_see_system_users_header() {
        adminPage = new AdminPage(driver);
        Assert.assertEquals("System Users", adminPage.getAdminHeaderText());
    }

    @Then("I can add a new user")
    public void i_can_add_a_new_user() {

    }
}
