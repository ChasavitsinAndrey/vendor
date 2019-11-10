package com.vendor.page;

import com.vendor.WebDriverHolder;
import com.vendor.environment.Environment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@type='e-mail']")
    private WebElement accountTextBox;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@class='invalid-input-message']")
    private WebElement wrongMailMessage;



    public void openVendorMainPage() {
        WebDriverHolder.getWebDriver().get(Environment.baseUrl);
    }

    public void performLogin() {
        setLogin();
        setPassword();
        clickSignInButton();
    }

    public void inputPassword( String pass ) {
        passwordTextBox.sendKeys(pass);
    }
    public void inputLogin(String acc) {
        accountTextBox.sendKeys(acc);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    private void setPassword( ) {
        passwordTextBox.sendKeys(Environment.pass);
    }

    private void setLogin() {
        accountTextBox.sendKeys(Environment.acc);
    }
    public String getWrongMessageText(){
        return wrongMailMessage.getText();
    }
}
