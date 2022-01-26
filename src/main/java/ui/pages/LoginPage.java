package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="txtUsername")
    private WebElement username;

    @FindBy(id="txtPassword")
    private WebElement password;

    @FindBy(id="btnLogin")
    private WebElement loginButton;

    @FindBy(id = "spanMessage")
    private WebElement errorMessage;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getErrorText(){
        return errorMessage.getText().trim();
    }

}
