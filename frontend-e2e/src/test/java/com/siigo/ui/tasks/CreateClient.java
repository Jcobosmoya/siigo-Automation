package com.siigo.ui.tasks;

import com.siigo.ui.models.Client;
import com.siigo.ui.pages.ClientCreationPage;
import com.siigo.ui.pages.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateClient implements Task {

    private final Client client;

    public CreateClient(Client client) {
        this.client = client;
    }

    public static CreateClient withData(Client client) {
        return instrumented(CreateClient.class, client);
    }

    @Step("{0} creates a new client with name #client.getName()")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(HomePage.CREATE_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
            Click.on(HomePage.CREATE_BUTTON),
            WaitUntil.the(HomePage.CLIENTS_OPTION, isVisible()).forNoMoreThan(10).seconds(),
            Click.on(HomePage.CLIENTS_OPTION),
            WaitUntil.the(ClientCreationPage.PAGE_TITLE, isVisible()).forNoMoreThan(15).seconds()
        );

        if (client.getName() != null && !client.getName().trim().isEmpty()) {
            actor.attemptsTo(Enter.theValue(client.getName()).into(ClientCreationPage.CLIENT_NAME_FIELD));
        }
        if (client.getEmail() != null && !client.getEmail().trim().isEmpty()) {
            actor.attemptsTo(Enter.theValue(client.getEmail()).into(ClientCreationPage.CLIENT_EMAIL_FIELD));
        }
        if (client.getPhone() != null && !client.getPhone().trim().isEmpty()) {
            actor.attemptsTo(Enter.theValue(client.getPhone()).into(ClientCreationPage.CLIENT_PHONE_FIELD));
        }
        if (client.getAddress() != null && !client.getAddress().trim().isEmpty()) {
            actor.attemptsTo(Enter.theValue(client.getAddress()).into(ClientCreationPage.CLIENT_ADDRESS_FIELD));
        }
        if (client.getId() != null && !client.getId().trim().isEmpty()) {
            actor.attemptsTo(Enter.theValue(client.getId()).into(ClientCreationPage.CLIENT_ID_FIELD));
        }

        actor.attemptsTo(
            Click.on(ClientCreationPage.SAVE_BUTTON)
        );

        try {
            actor.attemptsTo(WaitUntil.the(ClientCreationPage.SUCCESS_MESSAGE, isVisible()).forNoMoreThan(10).seconds());
        } catch (Exception e) {
            actor.attemptsTo(WaitUntil.the(ClientCreationPage.ERROR_MESSAGE, isVisible()).forNoMoreThan(2).seconds());
        }
    }
} 