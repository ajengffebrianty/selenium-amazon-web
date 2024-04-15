package imi.page.object.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPO {
    @FindBy(how = How.ID, using = "ap_email")
    WebElement emailInput;

    @FindBy(how = How.ID, using = "ap_password")
    WebElement passwordInput;

    @FindBy(how = How.ID, using = "continue")
    WebElement continueButton;

    @FindBy(how = How.ID, using = "signInSubmit")
    WebElement signInButton;


    @FindBy(how = How.ID, using = "auth-error-message-box")
    WebElement errorMessage;


    public void setEmailInputText(String email) {
        emailInput.sendKeys(email);
    }

    public void setPasswordInputText(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void continueButton() {
        continueButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean errorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}
