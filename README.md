# Siigo QA Challenge

Este repositorio contiene la solución al reto de automatización QA para Siigo, abarcando pruebas de API, pruebas End-to-End (E2E) de frontend y pruebas de performance.

## 🎯 Objetivo

Automatizar la validación funcional y de performance de la plataforma Siigo, aplicando buenas prácticas de ingeniería de pruebas, modularidad y mantenibilidad.

## 🧑‍💻 Justificación y Diseño

- **Separación de responsabilidades:** El proyecto está dividido en módulos independientes para backend (API), frontend (E2E) y performance, facilitando el mantenimiento y la escalabilidad.
- **Screenplay Pattern:** Se utiliza este patrón para lograr pruebas legibles, reutilizables y desacopladas, tanto en backend como en frontend.
- **Buenas prácticas:** Código limpio, modular, con Page Objects, Tasks y Questions bien definidos.
- **Documentación profesional:** Cada módulo cuenta con su propio README detallado.

## 📁 Estructura del Proyecto

```
siigo-qa-challenge/
├── backend-api/      # Pruebas automatizadas de API (Serenity BDD, Screenplay, Java)
├── frontend-e2e/     # Pruebas E2E de frontend (Serenity BDD, Screenplay, Java)
├── k6/               # Pruebas de performance (k6, JavaScript)
├── src/              # (Opcional, para recursos compartidos o ejemplos)
├── pom.xml           # Archivo de configuración Maven raíz
├── .gitignore        # Exclusiones de git
└── README.md         # Este archivo
```

## 🚀 Ejecución rápida

- **Backend:**  
  Ir a `backend-api/` y ejecutar:  
  `mvn clean verify`

- **Frontend:**  
  Ir a `frontend-e2e/` y ejecutar:  
  `mvn clean verify`

- **Performance:**  
  Ir a `k6/` y ejecutar:  
  `k6 run sample-script.js`

## 🛠️ Tecnologías usadas

- Java 11+
- Serenity BDD
- Screenplay Pattern
- Selenium WebDriver
- k6 (performance)
- Maven

## 📌 Notas importantes

- La API de pruebas requiere autenticación con header `x-api-key: reqres-free-v1`.
- El límite de la API gratuita es de 100 requests/día para POST/PUT/DELETE.
- Cada módulo tiene su propio README con detalles y ejemplos.

---

Para más detalles, revisa los README de cada módulo.

## Descripción de los módulos

- [`backend-api/`](./backend-api/):
  - Pruebas automatizadas para la API de Siigo.
  - Implementadas con Serenity BDD, Screenplay Pattern y Java.
  - [Ver README específico](./backend-api/README.md)

- [`frontend-e2e/`](./frontend-e2e/):
  - Pruebas End-to-End (E2E) para la aplicación web de Siigo.
  - Implementadas con Serenity BDD, Screenplay Pattern y Java.
  - [Ver README específico](./frontend-e2e/README.md)

- [`k6/`](./k6/):
  - Scripts de pruebas de performance usando k6 (JavaScript).
  - Incluye ejemplos de carga y validación de APIs.

## ¿Cómo clonar y ejecutar el proyecto?

1. **Clona el repositorio:**
   ```sh
   git clone https://github.com/Jcobosmoya/siigo.git
   cd siigo
   ```
2. **Revisa los README de cada módulo** para instrucciones detalladas de ejecución y dependencias.

## Contacto

Para dudas, sugerencias o mejoras, contacta al responsable del proyecto o revisa la documentación de [Serenity BDD](https://serenity-bdd.github.io/docs/), [Screenplay Pattern](https://serenity-js.org/handbook/design/screenplay-pattern.html) y [k6](https://k6.io/docs/).
