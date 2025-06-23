
# Siigo QA Challenge - Backend API

Este módulo contiene las pruebas automatizadas para la API de Siigo, implementadas con **Serenity BDD**, **Screenplay Pattern** y **Java**.

## Estructura del Proyecto

```
backend-api/
├── src/test/java/com/siigo/api/
│   ├── features/      # Clases de test (escenarios de API)
│   ├── models/        # Modelos de datos (ej: User.java)
│   ├── questions/     # Questions (ResponseCode, etc.)
│   └── tasks/         # Tasks (CreateUser, UpdateUser, DeleteUser, GetUsers)
├── pom.xml
└── README.md
```

## Patrón Screenplay: ¿Por qué y cómo?

- **Actors:** Representan a los consumidores de la API.
- **Tasks:** Acciones de alto nivel sobre la API (ej: crear, actualizar, eliminar usuario).
- **Questions:** Validaciones sobre la respuesta de la API (ej: ¿El código de respuesta es 201?).
- **Models:** Permiten manejar datos de entrada de forma tipada y clara.

**Ventajas:**
- Favorece la reutilización y la legibilidad.
- Permite construir flujos complejos de forma declarativa y mantenible.
- Facilita la separación de responsabilidades y el mantenimiento.

## Principales componentes

- `UsersApiTest.java`: Escenarios de prueba para los endpoints de usuario.
- `User.java`: Modelo de datos para usuarios.
- `CreateUser.java`, `UpdateUser.java`, `DeleteUser.java`, `GetUsers.java`: Tasks reutilizables para cada operación.
- `ResponseCode.java`: Question para validar códigos de respuesta.

## Ejemplo de flujo de prueba API

```java
actor.attemptsTo(
    CreateUser.withInfo(new User("Juan", "QA"))
);
actor.should(
    seeThat(ResponseCode.was(), equalTo(201))
);
actor.attemptsTo(
    UpdateUser.withInfo(1, new User("Juan", "Dev"))
);
actor.should(
    seeThat(ResponseCode.was(), equalTo(200))
);
actor.attemptsTo(
    DeleteUser.withId(1)
);
actor.should(
    seeThat(ResponseCode.was(), equalTo(204))
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
   - Abre `backend-api/target/site/serenity/index.html` en tu navegador.

## Justificación de diseño

- **Mantenibilidad:** Si cambia un endpoint o payload, solo se actualiza en el Task o Model correspondiente.
- **Escalabilidad:** Puedes agregar más Tasks, Questions y Models sin romper la estructura.
- **Claridad:** Los tests son legibles y expresan el flujo de negocio, no los detalles técnicos.
- **Separación de validaciones:** Las Questions están agrupadas y son reutilizables.

## Notas sobre autenticación

- La API de Reqres requiere el header `x-api-key: reqres-free-v1` para operaciones POST, PUT y DELETE. Este header ya está incluido en los Tasks correspondientes.

## Contacto

Para dudas o mejoras, contacta al responsable del proyecto o revisa la documentación de [Serenity BDD](https://serenity-bdd.github.io/docs/) y [Screenplay Pattern](https://serenity-js.org/handbook/design/screenplay-pattern.html). 
>>>>>>> e39995a ( proyecto QA Siigo: backend, frontend y performance)
