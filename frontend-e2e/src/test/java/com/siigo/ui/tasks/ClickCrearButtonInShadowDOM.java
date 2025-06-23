package com.siigo.ui.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.core.steps.Instrumented;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ClickCrearButtonInShadowDOM implements Task {

    public static ClickCrearButtonInShadowDOM click() {
        return Instrumented.instanceOf(ClickCrearButtonInShadowDOM.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = net.serenitybdd.core.Serenity.getWebdriverManager().getCurrentDriver();
        String script =
            "const header = document.querySelector('siigo-header-molecule');" +
            "if (header && header.shadowRoot) {" +
            "  const crearBtn = header.shadowRoot.querySelector('siigo-button-atom[data-id=\"header-create-button\"]');" +
            "  if (crearBtn) crearBtn.click();" +
            "}";
        ((JavascriptExecutor) driver).executeScript(script);
    }
} 