package com.siigo.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    // Título del dashboard/inicio
    public static final Target DASHBOARD_TITLE = Target.the("Dashboard title")
        .located(By.cssSelector("div.menu-tab-title-label"));

    // Botón Crear
    public static final Target CREATE_BUTTON = Target.the("Create button")
        .located(By.cssSelector("button.btn-element.size-m[type='button']"));

    // Opción Clientes
    public static final Target CLIENTS_OPTION = Target.the("Clients option")
        .located(By.cssSelector("a[data-value='Clientes']"));

    // Puedes agregar más Targets según lo necesites
} 