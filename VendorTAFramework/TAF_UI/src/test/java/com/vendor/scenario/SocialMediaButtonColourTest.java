package com.vendor.scenario;

//import com.ui.test.step.LoginStep;
//import com.ui.test.step.NavigationStep;
//import com.webdriver.WebDriverHolder;
//import com.webdriver.action.EventAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SocialMediaButtonColourTest extends BaseTest {

//    private LoginStep loginStep;
//    private NavigationStep navigationStep;
//    private String googleButtonBG;
//    private String facebookButtonBG;
//
//    @BeforeClass
//    @Parameters({"googleButtonBG", "facebookButtonBG"})
//    private void initialize(String googleButtonBG, String facebookButtonBG) {
//        navigationStep = new NavigationStep();
//        loginStep = new LoginStep();
//        this.googleButtonBG = googleButtonBG;
//        this.facebookButtonBG = facebookButtonBG;
//    }
//
//    @BeforeClass
//    private void navigateToAccountPage() {
//        navigationStep.openUberWelcomePage();
//        loginStep.navigateToLoginPage();
//        loginStep.navigateToRiderLoginPage();
//    }
//
//    @Test(description = "verify that social media colours, are the same as expected")
//    public void checkSocialNetworksButtonColours() {
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(loginStep.getFacebookButtonBG(), facebookButtonBG, "Facebook button colour different from expected");
//        softAssert.assertEquals(loginStep.getGoogleButtonBG(), googleButtonBG, "Google button colour different from expected");
//        softAssert.assertAll();
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void cleanCookieAndLocalStorage() {
//        WebDriverHolder.getWebDriver().manage().deleteAllCookies();
//        EventAction.clearLocalStorage();
//    }
}

