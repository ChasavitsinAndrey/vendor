package com.vendor.page;

import com.vendor.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    public BasePage() {
        WebDriver driver = WebDriverHolder.getWebDriver();
        PageFactory.initElements(driver,this);
    }
}
