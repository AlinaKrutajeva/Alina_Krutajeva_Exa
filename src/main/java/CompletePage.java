import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage {

    public CompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "complete-text")
    private WebElement successfulMessage;

    public String getMsgAfterOrder() {
        return successfulMessage.getText();
    }
}
