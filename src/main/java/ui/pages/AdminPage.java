package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement adminPageHeader;

    @FindBy()
    private WebElement addButton;

    public String getAdminHeaderText(){
        return adminPageHeader.getText().trim();
    }

    public void clickAddButton(){
        addButton.click();
    }
}
