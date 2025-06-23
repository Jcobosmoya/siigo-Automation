package com.siigo.ui.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.core.steps.Instrumented;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ClickClientesInShadowDOM implements Task {

    public static ClickClientesInShadowDOM click() {
        return Instrumented.instanceOf(ClickClientesInShadowDOM.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = net.serenitybdd.core.Serenity.getWebdriverManager().getCurrentDriver();
        String script =
            "const header = document.querySelector('siigo-header-molecule');" +
            "if (header && header.shadowRoot) {" +
            "  const dropdown = header.shadowRoot.querySelector('siigo-header-create-button-dropdown[data-id=\"header-create-button-dropdown\"]');" +
            "  if (dropdown) {" +
            "    const clientes = dropdown.querySelector('a[data-value=\"Clientes\"]');" +
            "    if (clientes) clientes.click();" +
            "  }" +
            "}";
        ((JavascriptExecutor) driver).executeScript(script);
    }
} 