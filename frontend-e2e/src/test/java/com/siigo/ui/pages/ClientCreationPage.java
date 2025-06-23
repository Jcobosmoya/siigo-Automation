package com.siigo.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ClientCreationPage extends PageObject {

    // Client creation form elements - Generic selectors for Siigo
    public static final Target CLIENT_NAME_FIELD = Target.the("Client name field")
            .located(By.cssSelector("input[name*='nombre'], input[name*='name'], #clientName, input[placeholder*='nombre']"));

    public static final Target CLIENT_EMAIL_FIELD = Target.the("Client email field")
            .located(By.cssSelector("input[type='email'], input[name*='email'], #clientEmail, input[placeholder*='email']"));

    public static final Target CLIENT_PHONE_FIELD = Target.the("Client phone field")
            .located(By.cssSelector("input[name*='telefono'], input[name*='phone'], #clientPhone, input[placeholder*='teléfono']"));

    public static final Target CLIENT_ADDRESS_FIELD = Target.the("Client address field")
            .located(By.cssSelector("input[name*='direccion'], input[name*='address'], #clientAddress, textarea[name*='direccion']"));

    public static final Target CLIENT_ID_FIELD = Target.the("Client ID field")
            .located(By.cssSelector("input[name*='identificacion'], input[name*='id'], #clientId, input[placeholder*='identificación']"));

    // Save button
    public static final Target SAVE_BUTTON = Target.the("Save button")
            .located(By.cssSelector("button.button.green.filled"));

    // Cancel button
    public static final Target CANCEL_BUTTON = Target.the("Cancel button")
            .located(By.cssSelector("button:contains('Cancelar'), button:contains('Cancel'), .cancel-btn"));

    // Success message
    public static final Target SUCCESS_MESSAGE = Target.the("Success message")
            .located(By.cssSelector(".success-message, .alert-success, .notification-success"));

    // Error message
    public static final Target ERROR_MESSAGE = Target.the("Error message")
            .located(By.cssSelector(".error-message, .alert-danger, .invalid-feedback"));

    // Page title to verify we're on client creation page
    public static final Target PAGE_TITLE = Target.the("Page title")
            .located(By.cssSelector("h1, .page-title, .form-title"));

    // Required field indicators
    public static final Target REQUIRED_FIELD_INDICATOR = Target.the("Required field indicator")
            .located(By.cssSelector(".required, [required], .mandatory"));
} 