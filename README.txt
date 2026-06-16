# Sistema de Gestión de Solicitudes Empresariales (SGSE)

## Descripción

El Sistema de Gestión de Solicitudes Empresariales (SGSE) es una aplicación desarrollada como proyecto académico para la asignatura de Arquitectura de Software Empresarial.

La solución permite centralizar la gestión de solicitudes dentro de una organización, facilitando el registro de usuarios, la creación y seguimiento de solicitudes, la administración de tipos de solicitud, la generación de reportes y la gestión de notificaciones asociadas a cambios de estado.

La aplicación fue desarrollada siguiendo principios de Arquitectura Empresarial, Arquitectura en Capas y buenas prácticas de desarrollo de software.

---

## Objetivos

* Centralizar la gestión de solicitudes empresariales.
* Mejorar la trazabilidad de los procesos.
* Facilitar el seguimiento de solicitudes.
* Reducir la dispersión de información.
* Generar reportes para apoyar la toma de decisiones.
* Aplicar conceptos de Arquitectura de Software Empresarial.

---

## Tecnologías Utilizadas

### Backend

* Java 21
* Spring Boot 4.1.0
* Spring Data JPA
* Spring Web MVC
* Maven

### Base de Datos

* MySQL

### Herramientas de Desarrollo

* Git
* GitHub
* Postman
* Eclipse IDE

---

## Arquitectura Implementada

El proyecto utiliza una Arquitectura en Capas compuesta por:

### Capa de Presentación

Responsable de recibir y procesar las solicitudes HTTP mediante controladores REST.

* UsuarioController
* TipoSolicitudController
* SolicitudController
* ReporteController

### Capa de Negocio

Contiene la lógica del sistema y las reglas de negocio.

* UsuarioService
* TipoSolicitudService
* SolicitudService
* NotificacionService
* ReporteService

### Capa de Persistencia

Gestiona el acceso a los datos mediante Spring Data JPA.

* UsuarioRepository
* TipoSolicitudRepository
* SolicitudRepository
* NotificacionRepository

### Capa de Datos

Base de datos MySQL encargada del almacenamiento persistente de la información.

---

## Patrones Implementados

### Repository

Implementado mediante interfaces que extienden JpaRepository.

Beneficios:

* Menor acoplamiento.
* Mejor mantenibilidad.
* Abstracción del acceso a datos.

### Dependency Injection

Utilizada mediante el contenedor de Spring para suministrar dependencias entre componentes.

### CQRS Básico

Separación entre operaciones de consulta y operaciones de modificación de datos.

### Observer

Aplicado para la generación automática de notificaciones cuando cambia el estado de una solicitud.

---

## Entidades Principales

### Usuario

Representa los usuarios registrados en el sistema.

### TipoSolicitud

Permite clasificar las solicitudes según su categoría.

### Solicitud

Entidad principal encargada de gestionar las solicitudes registradas.

### Notificacion

Gestiona los eventos generados por cambios de estado.

---

## Endpoints Disponibles

### Usuarios

| Método | Endpoint                   |
| ------ | -------------------------- |
| POST   | /Usuario/registrar_Usuario |

### Tipos de Solicitud

| Método | Endpoint                            |
| ------ | ----------------------------------- |
| POST   | /TipoSolicitud/Crear_Tipo_Solicitud |

### Solicitudes

| Método | Endpoint                        |
| ------ | ------------------------------- |
| POST   | /Solicitud/Crear_Solicitud      |
| POST   | /Solicitud/Cambiar_estado       |
| GET    | /Solicitud/Lista_Tipo_Solicitud |
| GET    | /Solicitud/Lista_Solicitudes    |

### Reportes

| Método | Endpoint                 |
| ------ | ------------------------ |
| GET    | /Reporte/Generar_Reporte |

---

## Configuración de Base de Datos

Crear una base de datos MySQL para el proyecto:

```sql
CREATE DATABASE sgse;
```

Configurar las credenciales en:

```properties
src/main/resources/application.properties
```

Ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sgse
spring.datasource.username=root
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Ejecución del Proyecto

### Clonar repositorio

```bash
git clone https://github.com/usuario/SGSE_Springboot.git
```

### Ingresar al proyecto

```bash
cd SGSE_Springboot
```

### Ejecutar

```bash
./mvnw spring-boot:run
```

o

```bash
mvn spring-boot:run
```

---

## Pruebas

Las pruebas funcionales de los servicios REST fueron realizadas mediante Postman.

Las pruebas permitieron validar:

* Registro de usuarios.
* Creación de tipos de solicitud.
* Creación de solicitudes.
* Cambio de estados.
* Consulta de información.
* Generación de reportes.

---

## Atributos de Calidad

El proyecto fue diseñado considerando los siguientes atributos de calidad:

* Mantenibilidad
* Escalabilidad
* Trazabilidad
* Testabilidad

---

## Autores

* Wilmar Enrique Cardona Rodríguez
* Valentina Gómez Gómez
* Juan David Grisalez Ortega

Asignatura: Arquitectura de Software Empresarial

---

## Licencia

Proyecto desarrollado con fines académicos.
