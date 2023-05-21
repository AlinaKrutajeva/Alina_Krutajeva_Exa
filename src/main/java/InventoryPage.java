import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {

    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item")
    private List<WebElement> productIdName;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productTitles;

    @FindBy(id = "item_4_img_link")
    private WebElement backpackItem;

    @FindBy(className = "product_sort_container")
    private WebElement filterField;

    @FindBy(css = "option[value='lohi']")
    private WebElement optionLowToHigh;

    public boolean productsAreDisplayed() {
        return productIdName.stream()
                .allMatch(WebElement::isDisplayed);
    }

    public int getAmountOfItems() {
        return productIdName.size();
    }

    public void getItemsTitles() {
        List<String> itemTitles = productTitles.stream()
                .map(WebElement::getText)
                .toList();
        itemTitles.forEach(System.out::println);
    }

    public void openBackpackProduct() {
        backpackItem.click();
    }

    public boolean filterFieldIsInitialized() {
        return filterField.isDisplayed();
    }

    public void selectPriceLowToHigh() {
        filterField.click();
        optionLowToHigh.click();
    }
}


