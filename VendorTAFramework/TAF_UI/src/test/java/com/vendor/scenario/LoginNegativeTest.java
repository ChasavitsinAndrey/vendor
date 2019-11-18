package com.vendor.scenario;

import com.vendor.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginNegativeTest extends BaseTestWithDownload {

    private LoginPage loginPage;

    @BeforeClass
    private void initialize() {
        loginPage = new LoginPage();
    }

    @Test(description = "verify that error message displays for user in case of invalid login")
    public void isErrorBlockDisplayed() {
        loginPage.openVendorMainPage();
        loginPage.inputLogin("123ads@tut.by");
        loginPage.inputPassword("qwerty");
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getWrongMessageText(), "Неверный e-mail или пароль.");
    }

    @Test(description = "just to verify login")
    public void success() throws InterruptedException {
        loginPage.openVendorMainPage();
        loginPage.performLogin();
        Thread.sleep(5000);
    }
}
