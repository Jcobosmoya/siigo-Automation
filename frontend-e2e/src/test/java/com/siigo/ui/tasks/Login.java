package com.siigo.ui.tasks;

import com.siigo.ui.pages.LoginPage;
import com.siigo.ui.pages.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private final String email;
    private final String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Login withCredentials(String email, String password) {
        return instrumented(Login.class, email, password);
    }

    @Step("{0} logs in with email #email")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(LoginPage.EMAIL_FIELD, isVisible()).forNoMoreThan(10).seconds(),
            Enter.theValue(email).into(LoginPage.EMAIL_FIELD),
            Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
            Click.on(LoginPage.LOGIN_BUTTON)
        );

        // Wait for the dashboard title to be visible as confirmation of login
        try {
            actor.attemptsTo(WaitUntil.the(HomePage.DASHBOARD_TITLE, isVisible()).forNoMoreThan(15).seconds());
        } catch (Exception e) {
            // If dashboard title does not appear, check for an error message
            actor.attemptsTo(WaitUntil.the(LoginPage.ERROR_MESSAGE, isVisible()).forNoMoreThan(2).seconds());
        }
    }
} 