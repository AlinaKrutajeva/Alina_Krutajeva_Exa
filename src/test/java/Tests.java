import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class Tests extends TestDataProvider {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    ProductDetails productDetails;
    ChartPage chartPage;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;
    CompletePage completePage;


    @BeforeClass(groups={"firstTest","secondTest","thirdTest","fourthTest","fifthTest"})
    private void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }

    @BeforeMethod(groups={"firstTest","secondTest","thirdTest","fourthTest","fifthTest"})
    public void initialize() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        productDetails = new ProductDetails(driver);
        chartPage = new ChartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
        completePage = new CompletePage(driver);
    }

    @AfterClass(groups = {"firstTest","secondTest","thirdTest","fourthTest","fifthTest"})
    private void closeDriver() {
        driver.close();
        driver.quit();
    }

    @Test(groups = {"firstTest"})
    public void firstTest() throws InterruptedException {
        Assert.assertTrue(loginPage.isFirstNameFieldDisplayed());
        Assert.assertTrue(loginPage.isSurnameFieldDisplayed());
        loginPage.login("standard_user",
                "secret_sauce");
        System.out.println("Page has: " + inventoryPage.getAmountOfItems() + " items.");
        Reporter.log("Page has: " + inventoryPage.getAmountOfItems() + " items.");
    }

    @Test(groups = {"secondTest"})
    public void secondTest() throws Exception {
        Assert.assertTrue(loginPage.isFirstNameFieldDisplayed());
        Assert.assertTrue(loginPage.isSurnameFieldDisplayed());
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.filterFieldIsInitialized());
        inventoryPage.selectPriceLowToHigh();
        takeScreenShoot("test2//test2.png", "Screenshot saved in test2 folder.");
    }

    @Test(groups = {"thirdTest"})
    public void thirdTest() throws InterruptedException {
        Assert.assertTrue(loginPage.isFirstNameFieldDisplayed());
        Assert.assertTrue(loginPage.isSurnameFieldDisplayed());
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.productsAreDisplayed());
        inventoryPage.getItemsTitles();
    }

    @Test(dataProvider = "create", groups = {"fourthTest"})
    public void fourthTest(String name, String surname) throws Exception {
        Assert.assertTrue(loginPage.isFirstNameFieldDisplayed());
        Assert.assertTrue(loginPage.isSurnameFieldDisplayed());
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.productsAreDisplayed());
        inventoryPage.openBackpackProduct();
        productDetails.addBackpackToChart();
        Assert.assertEquals(productDetails.getChartProductsAmount(), "1",
                "Chart has incorrect amount of added items.");
        productDetails.openChart();
        chartPage.clickCheckout();
        checkoutPage.enterFirstName(name)
                .enterLastName(surname)
                .enterZip("LV-1082")
                .clickCheckout();
        overviewPage.clickFinish();
       Assert.assertEquals(completePage.getMsgAfterOrder(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
               "Order is not sent.");
        takeScreenShoot("test4//test4.png", "Screenshot saved in test4 folder." );
        driver.get("https://www.saucedemo.com/");

    }

    @Test(groups={"fifthTest"})
    public void fifthTest() throws Exception {
        Assert.assertTrue(loginPage.isFirstNameFieldDisplayed());
        Assert.assertTrue(loginPage.isSurnameFieldDisplayed());
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.openBackpackProduct();
        productDetails.addBackpackToChart();
        Assert.assertEquals(productDetails.getChartProductsAmount(), "1",
                "Chart has incorrect amount of added items.");
        productDetails.openChart();
        chartPage.clickRemove();
        Assert.assertTrue(chartPage.isChartEmpty(), "Chart is not empty.");
        takeScreenShoot("test5//test5.png", "Screenshot saved in test5 folder.");
    }

    private void takeScreenShoot(String fileLocation, String msg) throws Exception {
        takeSnapShot(driver, fileLocation);
        System.out.println(msg);
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
