package com.siigo.ui.questions;

import com.siigo.ui.pages.LoginPage;
import com.siigo.ui.pages.HomePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class LoginQuestions {

    public static Question<Boolean> isLoggedInSuccessfully() {
        return Visibility.of(HomePage.DASHBOARD_TITLE);
    }

    public static Question<Boolean> displaysErrorMessage() {
        return Visibility.of(LoginPage.ERROR_MESSAGE);
    }

    public static Question<Boolean> createOptionsAreVisible() {
        return Visibility.of(HomePage.CLIENTS_OPTION);
    }

    public static Question<Boolean> isCreateButtonVisible() {
        return Visibility.of(HomePage.CREATE_BUTTON);
    }
} 