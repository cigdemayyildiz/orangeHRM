package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='head']")
    private WebElement dashboard;

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminButton;

    public String getDashboardText(){
        return dashboard.getText().trim();
    }

    public void clickAdminButton(){
        adminButton.click();
    }
}
