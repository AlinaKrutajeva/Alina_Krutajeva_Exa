import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "user-name")
    private WebElement usernameField;

    @FindBy(name = "login-button")
    private WebElement loginButton;

    @FindBy(name = "password")
    private WebElement passwordField;

    public boolean isFirstNameFieldDisplayed() {
        return usernameField.isDisplayed();
    }

    public boolean isSurnameFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public void login(String searchFirstText, String searchSecondText) throws InterruptedException {
        usernameField.sendKeys(searchFirstText);
        passwordField.sendKeys(searchSecondText);
        loginButton.click();
    }


}
