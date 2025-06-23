package com.siigo.ui.questions;

import com.siigo.ui.pages.HomePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class HomeQuestions {

    public static Question<Boolean> isDashboardTitleVisible() {
        return Visibility.of(HomePage.DASHBOARD_TITLE);
    }

    public static Question<Boolean> isCreateButtonVisible() {
        return Visibility.of(HomePage.CREATE_BUTTON);
    }

    public static Question<Boolean> isClientsOptionVisible() {
        return Visibility.of(HomePage.CLIENTS_OPTION);
    }
} 