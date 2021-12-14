# Proyecto Test para Mercadolibre Implementando Clean Architecture
## Instrucciones para levantar el microservicio en ambiente local

1. Se deben definir las siguientes variables de entorno:

 - SPRING_PROFILES_ACTIVE=local;
 - LOG4J_LEVEL=INFO;
 - APIC_TIMEOUT=3000;

2. Se debe importar el proyecto como un proyecto Gradle.

3. Compilar el proyecto con JAVA_11.
4. Ejecutar la clase principal ubicada en:
   
    - /applications/app-service/src/main/java/con.com.test.mercadolibre/MainApplication.java
## Antes de Iniciar

Empezaremos por explicar los diferentes componentes del proyecto.
# Arquitectura
## Domain
Es el módulo más interno de la arquitectura, pertenece a la capa del dominio y encapsula la lógica y reglas del negocio mediante modelos y entidades del dominio.

## Usecases
Este módulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define lógica de aplicación y reacciona a las invocaciones desde el módulo de entry points, orquestando los flujos hacia el módulo de entities.

## Infrastructure

### Driven Adapters
Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
 interactuar.

### Entry Points
Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio, para este caso por medio routes y handlers.

