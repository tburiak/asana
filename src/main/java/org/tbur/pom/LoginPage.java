package org.tbur.pom;

import com.microsoft.playwright.Locator;

public class LoginPage extends BasePage {

    private static final String LOGIN_URL = "https://app.asana.com/-/login";
    private static final String EMAIL = "ben+pose@workwithloop.com";
    private static final String PASSWORD = "Password123";

    private Locator inputEmail;
    private Locator inputPassword;
    private Locator buttonLogin;
    private Locator buttonContinue;

    @Override
    public void initElements() {
        inputEmail = page.locator("//*[@type='email']");
        inputPassword = page.locator("//*[@type='password']");
        buttonContinue = page.locator("//*[@role='button' and .='Continue']");
        buttonLogin = page.locator("//*[@role='button' and .='Log in']");
    }

    public MainPage login() {
        page.navigate(LOGIN_URL);
        inputEmail.fill(EMAIL);
        buttonContinue.click();
        inputPassword.fill(PASSWORD);
        buttonLogin.click();
        page.waitForLoadState();
        return PageFactory.createInstance(page, MainPage.class);
    }

}
