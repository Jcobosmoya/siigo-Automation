package com.siigo.ui.features;

import com.siigo.ui.questions.LoginQuestions;
import com.siigo.ui.tasks.Login;
import com.siigo.ui.pages.LoginPage;
import com.siigo.ui.pages.HomePage;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@ExtendWith(SerenityJUnit5Extension.class)
@DisplayName("Siigo E2E Test Suite")
public class ClientCreationE2ETest {

    private final Actor user = Actor.named("QA User");

    @Managed(driver = "chrome")
    private WebDriver herBrowser;

    private static final String LOGIN_URL = "https://qastaging.siigo.com/#/login";

    @BeforeEach
    void setUp() {
        user.can(BrowseTheWeb.with(herBrowser));
        user.wasAbleTo(Open.url(LOGIN_URL));
    }

    @Test
    @DisplayName("Should login and see dashboard title")
    void shouldLoginAndSeeDashboardTitle() {
        givenThat(user).attemptsTo(
            Login.withCredentials("retoautomationsiigo@yopmail.com", "T4b4ck0ff1c3P455w0rd658*")
        );

        when(user).should(
            seeThat(LoginQuestions.isLoggedInSuccessfully(), is(true))
        );
    }

    @Test
    @DisplayName("Should login, click Crear and select Clientes")
    void shouldLoginAndGoToCreateClient() {
        givenThat(user).attemptsTo(
            Login.withCredentials("retoautomationsiigo@yopmail.com", "T4b4ck0ff1c3P455w0rd658*")
        );

        // Esperar y hacer clic en el botón Crear
        user.attemptsTo(
            WaitUntil.the(HomePage.DASHBOARD_TITLE, isVisible()).forNoMoreThan(15).seconds(),
            com.siigo.ui.tasks.ClickCrearButtonInShadowDOM.click()
        );

        // Esperar y hacer clic en la opción Clientes
        user.attemptsTo(
            com.siigo.ui.tasks.ClickClientesInShadowDOM.click()
        );
        // Espera de 10 segundos para asegurar que la página de creación de cliente cargue
        try { Thread.sleep(10000); } catch (InterruptedException e) { e.printStackTrace(); }
        // Llenar el campo de identificación
        user.attemptsTo(
            com.siigo.ui.tasks.EnterIdentificacionInShadowDOM.withValue("123456789")
        );
        // Llenar el campo de nombre (segundo siigo-textfield-web)
        user.attemptsTo(
            com.siigo.ui.tasks.EnterTextFieldByIndexInShadowDOM.atIndexWithValue(1, "Juan")
        );
        // Llenar el campo de apellido (tercer siigo-textfield-web)
        user.attemptsTo(
            com.siigo.ui.tasks.EnterTextFieldByIndexInShadowDOM.atIndexWithValue(2, "Pérez")
        );
        // Hacer clic en el botón Guardar
        user.attemptsTo(
            net.serenitybdd.screenplay.actions.Click.on(com.siigo.ui.pages.ClientCreationPage.SAVE_BUTTON)
        );
        // Aquí podrías agregar una validación de que se abrió el formulario de clientes
    }
} 