package com.siigo.ui.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.core.steps.Instrumented;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EnterTextFieldByIndexInShadowDOM implements Task {

    private final int index;
    private final String value;

    public EnterTextFieldByIndexInShadowDOM(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public static EnterTextFieldByIndexInShadowDOM atIndexWithValue(int index, String value) {
        return Instrumented.instanceOf(EnterTextFieldByIndexInShadowDOM.class).withProperties(index, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = net.serenitybdd.core.Serenity.getWebdriverManager().getCurrentDriver();
        String script =
            "const fields = document.querySelectorAll('siigo-textfield-web');" +
            "if (fields.length > arguments[0]) {" +
            "  const field = fields[arguments[0]];" +
            "  if (field && field.shadowRoot) {" +
            "    const input = field.shadowRoot.querySelector('input.mdc-text-field__input');" +
            "    if (input) {" +
            "      input.value = arguments[1];" +
            "      input.dispatchEvent(new Event('input', { bubbles: true }));" +
            "    }" +
            "  }" +
            "}";
        ((JavascriptExecutor) driver).executeScript(script, index, value);
    }
} 