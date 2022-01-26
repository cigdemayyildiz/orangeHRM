package ui.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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


    @Given("OrangeHrm home page")
    public void orange_hrm_home_page() {
        driver.get(ConfigReader.readProperty("url"));
        loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("username"),ConfigReader.readProperty("password"));
    }

    @When("click the Admin button")
    public void click_the_admin_button() {
        homePage = new HomePage(driver);
        homePage.clickAdminButton();
    }

    @When("click the Add button")
    public void click_the_add_button() {
        adminPage = new AdminPage(driver);
        adminPage.clickAddButton();
    }

    @Then("verify add page header")
    public void verify_add_page_header() {
        adminPage = new AdminPage(driver);
        Assert.assertEquals("Add User", adminPage.getAdminHeaderText());
    }





}
