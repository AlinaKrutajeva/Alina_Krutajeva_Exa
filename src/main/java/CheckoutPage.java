import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="first-name")
    private WebElement firstNameField;

    @FindBy(id="last-name")
    private WebElement lastnameField;

    @FindBy(id="postal-code")
    private WebElement zipCodeField;

    @FindBy(id="continue")
    private WebElement continueButton;

    public CheckoutPage enterFirstName(String name) {
        firstNameField.sendKeys(name);
        return this;
    }

    public CheckoutPage enterLastName(String surname) {
        lastnameField.sendKeys(surname);
        return this;
    }

    public CheckoutPage enterZip(String zip) {
        zipCodeField.sendKeys(zip);
        return this;
    }

    public void clickCheckout() {
        continueButton.click();
    }
}
