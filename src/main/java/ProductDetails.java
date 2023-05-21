import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {

    public ProductDetails(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToChartButton;

    @FindBy(className="shopping_cart_badge")
    private WebElement chartItemBadge;

    @FindBy(className="shopping_cart_link")
    private WebElement chartButton;

    public ProductDetails addBackpackToChart() {
        addBackpackToChartButton.click();
        return this;
    }

    public void openChart() {
        chartButton.click();
    }

    public String getChartProductsAmount() {
        return chartItemBadge.getText();
    }
}
