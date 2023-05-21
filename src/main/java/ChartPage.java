import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ChartPage {

    public ChartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBagButton;

    @FindBy(className = "removed_cart_item")
    private WebElement emptyCart;

    @FindBy(xpath = "//div[@class='cart_list']/div")
    private List<WebElement> cartElements;

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void clickRemove() {
        removeBagButton.click();
    }

    public boolean isChartEmpty() {
        List<String> allClasses = new ArrayList<>();

        for (WebElement item : cartElements) {
            allClasses.add(item.getAttribute("class"));
        }
        return allClasses.contains("removed_cart_item");
    }
}