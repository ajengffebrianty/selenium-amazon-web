package imi.page.object.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftSideBarPO {
    @FindBy(how = How.ID, using = "nav-hamburger-menu")
    WebElement allButton;

    @FindBy(how = How.XPATH, using = "//a[@data-menu-id='5']")
    WebElement electronicButton;

    @FindBy(how = How.XPATH, using = "//a[@class ='hmenu-item' and contains(text(),'Television & Video')]")
    WebElement tvVideoButton;

    public void clickAllButton() {
        allButton.click();
    }

    public void selectElectronicButton() {
        electronicButton.click();
    }

    public void selectTelevisionVideoButton() {
        tvVideoButton.click();
    }
}
