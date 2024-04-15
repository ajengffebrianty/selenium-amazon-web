package imi.page.object.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ProductListPO {

    @FindBy(how = How.LINK_TEXT, using = "Televisions")
    WebElement televisionsText;

    @FindBy(how = How.LINK_TEXT, using = "32 Inches & Under")
    WebElement size32Text;

    @FindBy(how = How.LINK_TEXT, using = "2017")
    WebElement year2017Text;

    @FindBy(how = How.XPATH, using = ".//span[@class='a-price-whole']")
    WebElement priceText;

    @FindBy(how = How.XPATH, using = "//input[@id='high-price']")
    WebElement maxPricesInput;

    @FindBy(how = How.XPATH, using = "//span[@class='a-button a-spacing-top-mini a-button-base s-small-margin-left']")
    WebElement goButton;

    @FindBy(how = How.ID, using = "a-autoid-0-announce")
    WebElement sortingButton;

    @FindBy(how = How.ID, using = "s-result-sort-select_2")
    WebElement priceDescendingButton;

    @FindBy(how = How.XPATH, using = "//div[@data-cel-widget='search_result_1']")
    WebElement productSelect;

    @FindBy(how = How.XPATH, using = "//*[starts-with(@data-asin,'B') and @data-index]")
    List<WebElement> productList;


    public void selectTelevisionLink() {
        televisionsText.click();
    }

    public void selectSize32CheckBox() {
        size32Text.click();
    }

    public void select2017CheckBox() {
        year2017Text.click();
    }

    public void getPriceText() {
        priceText.getText();
    }

    public void setMaxPriceInput(String price) {
        maxPricesInput.sendKeys(price);
    }

    public void clickGoButton() {
        goButton.click();
    }

    public void clickSortingButton() {
        sortingButton.click();
    }

    public void descPriceButton() {
        priceDescendingButton.click();
    }

    public void clickFirstProductLink() {
        productSelect.click();
    }

    public List<WebElement> getProductList() {
        return productList;
    }


}
