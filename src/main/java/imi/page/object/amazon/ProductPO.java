package imi.page.object.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPO {

    @FindBy(how = How.ID, using = "wishlistButtonStack")
    WebElement addToListButton;

    public void clickAddToListButton() {
        addToListButton.click();
    }
}
