# Siigo QA Challenge - Frontend E2E

Este módulo contiene las pruebas automatizadas End-to-End (E2E) para la aplicación web de Siigo, implementadas con **Serenity BDD**, **Screenplay Pattern** y **Java**.

## Estructura del Proyecto

```
frontend-e2e/
├── src/test/java/com/siigo/ui/
│   ├── features/      # Clases de test (escenarios E2E)
│   ├── models/        # Modelos de datos (ej: Client.java)
│   ├── pages/         # Page Objects (LoginPage, HomePage, ClientCreationPage)
│   ├── questions/     # Questions (LoginQuestions, HomeQuestions, ClientQuestions)
│   └── tasks/         # Tasks (Login, CreateClient, Click en shadow DOM, etc.)
├── src/test/resources/serenity.conf
├── pom.xml
└── README.md
```

## Patrón Screenplay: ¿Por qué y cómo?

- **Actors:** Representan a los usuarios (ej: `QA User`).
- **Tasks:** Acciones de alto nivel que realiza el actor (ej: Login, crear cliente, clicks en shadow DOM).
- **Questions:** Validaciones sobre el estado de la UI (ej: ¿Está visible el dashboard? ¿Se muestra un mensaje de error?).
- **Page Objects:** Centralizan los selectores y Targets de cada página, facilitando el mantenimiento y la reutilización.
- **Models:** Permiten manejar datos de entrada de forma tipada y clara.

**Ventajas:**
- Favorece la reutilización y la legibilidad.
- Permite construir flujos complejos de forma declarativa y mantenible.
- Facilita la separación de responsabilidades y el mantenimiento.

## Principales componentes

- `LoginPage.java`, `HomePage.java`, `ClientCreationPage.java`: Page Objects para cada pantalla relevante.
- `LoginQuestions.java`, `HomeQuestions.java`, `ClientQuestions.java`: Questions agrupadas por página.
- `Login.java`, `CreateClient.java`, `ClickCrearButtonInShadowDOM.java`, `ClickClientesInShadowDOM.java`, etc.: Tasks reutilizables y especializadas.
- `Client.java`: Modelo de datos para clientes.

## Ejemplo de flujo E2E

```java
user.attemptsTo(
    Login.withCredentials("usuario", "contraseña")
);
user.should(
    seeThat(HomeQuestions.isDashboardTitleVisible(), is(true))
);
user.attemptsTo(
    ClickCrearButtonInShadowDOM.click(),
    ClickClientesInShadowDOM.click()
);
// Espera para carga de página
try { Thread.sleep(10000); } catch (InterruptedException e) { e.printStackTrace(); }
user.attemptsTo(
    EnterIdentificacionInShadowDOM.withValue("123456789"),
    EnterTextFieldByIndexInShadowDOM.atIndexWithValue(1, "Juan"),
    EnterTextFieldByIndexInShadowDOM.atIndexWithValue(2, "Pérez"),
    Click.on(ClientCreationPage.SAVE_BUTTON)
);
```

## ¿Cómo ejecutar los tests?

1. **Instala dependencias:**
   ```sh
   mvn clean install
   ```
2. **Ejecuta los tests:**
   ```sh
   mvn clean verify
   ```
3. **Revisa los reportes Serenity:**
   - Abre `frontend-e2e/target/site/serenity/index.html` en tu navegador.

## Justificación de diseño

- **Mantenibilidad:** Si cambia un selector, solo se actualiza en el Page Object correspondiente.
- **Escalabilidad:** Puedes agregar más Tasks, Questions y Page Objects sin romper la estructura.
- **Claridad:** Los tests son legibles y expresan el flujo de negocio, no los detalles técnicos.
- **Soporte para aplicaciones modernas:** El uso de JavaScript en Tasks permite interactuar con shadow DOM, algo común en apps modernas (Web Components).
- **Separación de validaciones:** Las Questions están agrupadas por página, lo que facilita la reutilización y el mantenimiento.

## Contacto

Para dudas o mejoras, contacta al responsable del proyecto o revisa la documentación de [Serenity BDD](https://serenity-bdd.github.io/docs/) y [Screenplay Pattern](https://serenity-js.org/handbook/design/screenplay-pattern.html). 