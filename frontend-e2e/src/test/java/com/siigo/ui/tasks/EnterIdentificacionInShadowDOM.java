package com.siigo.ui.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.core.steps.Instrumented;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EnterIdentificacionInShadowDOM implements Task {

    private final String identificacion;

    public EnterIdentificacionInShadowDOM(String identificacion) {
        this.identificacion = identificacion;
    }

    public static EnterIdentificacionInShadowDOM withValue(String identificacion) {
        return Instrumented.instanceOf(EnterIdentificacionInShadowDOM.class).withProperties(identificacion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = net.serenitybdd.core.Serenity.getWebdriverManager().getCurrentDriver();
        String script =
            "const siigoInput = document.querySelector('siigo-identification-input-web');" +
            "if (siigoInput && siigoInput.shadowRoot) {" +
            "  const input = siigoInput.shadowRoot.querySelector('input.input-identification');" +
            "  if (input) {" +
            "    input.value = arguments[0];" +
            "    input.dispatchEvent(new Event('input', { bubbles: true }));" +
            "  }" +
            "}";
        ((JavascriptExecutor) driver).executeScript(script, identificacion);
    }
} 