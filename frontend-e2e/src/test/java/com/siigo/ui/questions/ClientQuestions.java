package com.siigo.ui.questions;

import com.siigo.ui.pages.ClientCreationPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ClientQuestions {

    public static Question<Boolean> clientWasCreatedSuccessfully() {
        return Visibility.of(ClientCreationPage.SUCCESS_MESSAGE);
    }

    public static Question<Boolean> clientCreationFormIsVisible() {
        return Visibility.of(ClientCreationPage.PAGE_TITLE);
    }

    public static Question<Boolean> validationErrorsAreDisplayed() {
        return Visibility.of(ClientCreationPage.ERROR_MESSAGE);
    }

    public static Question<Boolean> isClientFormVisible() {
        return Visibility.of(ClientCreationPage.CLIENT_NAME_FIELD);
    }

    public static Question<Boolean> isClientCreatedSuccessfully() {
        return Visibility.of(ClientCreationPage.SUCCESS_MESSAGE);
    }

    public static Question<Boolean> isValidationErrorDisplayed() {
        return Question.about("Validation error displayed").answeredBy(actor -> 
            actor.asksFor(Visibility.of(ClientCreationPage.ERROR_MESSAGE))
        );
    }

    public static Question<Boolean> isSaveButtonEnabled() {
        return Question.about("Save button enabled").answeredBy(actor -> 
            actor.asksFor(Visibility.of(ClientCreationPage.SAVE_BUTTON))
        );
    }
} 