import com.google.gson.Gson;
import imi.function.amazon.Television;
import imi.function.amazon.TelevisionPriceName;
import imi.page.object.amazon.LeftSideBarPO;
import imi.page.object.amazon.LoginPO;
import imi.page.object.amazon.ProductListPO;
import imi.page.object.amazon.ProductPO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationTestCheckout {
    public WebDriver driver;

    public AutomationTestCheckout() {

    }

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
    }

    @Test
    public void Test() {
        LeftSideBarPO sortProduct = PageFactory.initElements(driver, LeftSideBarPO.class);
        ProductListPO productList = PageFactory.initElements(driver, ProductListPO.class);
        ProductPO product = PageFactory.initElements(driver, ProductPO.class);
        LoginPO login = PageFactory.initElements(driver, LoginPO.class);

        TelevisionPriceName priceNameList = PageFactory.initElements(driver, TelevisionPriceName.class);

        sortProduct.clickAllButton();
        sortProduct.selectElectronicButton();
        sortProduct.selectTelevisionVideoButton();
        productList.selectTelevisionLink();
        productList.selectSize32CheckBox();
        productList.clickSortingButton();
        productList.descPriceButton();
        System.out.println("...wait for list product.....");
        List<Television> tvAll = priceNameList.listOfTelevision(productList.getProductList());
        System.out.println("All Product: ");
        System.out.println(new Gson().toJson(tvAll));
        productList.select2017CheckBox();
        productList.setMaxPriceInput("150");
        productList.clickGoButton();
        List<Television> tvFilter = priceNameList.listOfTelevision(productList.getProductList());
        System.out.println("Model: 2017, Price: Max $150:");
        System.out.println(new Gson().toJson(tvFilter));
        productList.clickFirstProductLink();
        product.clickAddToListButton();
        Assert.assertEquals(driver.getTitle(), "Amazon Sign-In");
        login.setEmailInputText("ali@gmail.com");
        login.continueButton();
        login.setPasswordInputText("1212");
        login.clickSignInButton();
        Assert.assertTrue(login.errorMessageDisplayed());
        System.out.println("----");
        System.out.println(login.getErrorMessage());
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
