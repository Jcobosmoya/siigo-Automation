package com.siigo.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    // Login form elements
    public static final Target EMAIL_FIELD = Target.the("Email field")
            .located(By.id("siigoSignInName"));

    public static final Target PASSWORD_FIELD = Target.the("Password field")
            .located(By.id("siigoPassword"));

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .located(By.id("siigoNext"));

    public static final Target ERROR_MESSAGE = Target.the("Error message")
            .located(By.cssSelector(".error-message, .alert-danger, .invalid-feedback"));

    // Shadow host for the Create button
    public static final Target CREATE_BUTTON_SHADOW_HOST = Target.the("Create button shadow host")
            .located(By.cssSelector("siigo-button-atom"));
} 