# Ejemplo Web Service con Sprint Boot Actuator
## Diagrama de secuencia

![Spring-Web-Service](Spring-Web-Service.png)

## Dependencias

- Java
- Spring Boot
  - Spring Boot Actuator
  - Spring Boot Web

## Descripción

### Spring Boot

Facilita el desarrollo de una aplicación basada en Spring. Evita mucho código repetitivo. Oculta mucha complejidad detrás de escena para que el desarrollador pueda comenzar rápidamente a desarrollar fácilmente aplicaciones basadas en Spring.

### Spring Boot Actuator

Es un subproyecto del Spring Boot Framework. Incluye una serie de características adicionales que nos ayudan a monitorear y administrar la aplicación Spring Boot. Contiene los puntos finales del actuador (el lugar donde viven los recursos). Podemos usar puntos finales HTTP y JMX para administrar y monitorear la aplicación Spring Boot. Si queremos obtener características listas para producción en una aplicación, debemos usar el actuador Spring Boot.

Características del **Spring Boot Actuator:**

- Endpoints
- Métrica
- Auditoría

#### Endpoints

Los endpoints nos permiten monitorear e interactuar con la aplicación. Spring Boot proporciona una serie de endpoints integrados. También podemos crear nuestro propio endpoints. Podemos habilitar y deshabilitar cada endpoint individualmente. La mayoría de la aplicación elige HTTP, donde el Id del endpoint, junto con el prefijo / actuador, se asigna a una URL.

Por ejemplo, el endpoint / health proporciona la información básica de salud de una aplicación. El actuador, por defecto, lo asignó a / actuator / health.

#### Métricas

Spring Boot Actuator proporciona métricas dimensionales al integrarse con el micrómetro. El micrómetro está integrado en Spring Boot. Es la biblioteca de instrumentación que impulsa la entrega de métricas de aplicaciones de Spring. Proporciona interfaces independientes del proveedor para temporizadores, medidores, contadores, resúmenes de distribución y temporizadores de tareas largas con un modelo de datos dimensionales.

#### Auditoría

Spring Boot proporciona un marco de auditoría flexible que publica eventos en un AuditEventRepository. Publica automáticamente los eventos de autenticación si spring-security está en ejecución.

## Configuración de Gradle

```groovy
plugins {
	id 'org.springframework.boot' version '2.2.7.RELEASE'
	id 'io.spring.dependency-management' version '1.0.9.RELEASE'
	id 'java'
}

group = 'cr.una.backend'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-actuator'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}
}

test {
	useJUnitPlatform()
}
```

## Probar el ejemplo

1. Correr la clase `ActuatorServiceApplication` la cual contiene el Main de la aplicación

2. Probar el siguiente endpoint `http://localhost:8080/actuator/health` verificar que el resultado sea **UP**:

   ![endpoint-health](endpoint-health.png)

3. Probar el API de los estudiantes `http://localhost:8080/api/students` verificar el resultado:

   ![endpint-students](endpoint-students.png)

4. Probar el API para obtener un solo estudiante `http://localhost:8080/api/students/123` y verificar el resultado:

   ![endpint-students](endpoint-student-by-id.png)

## Cambiar a un puerto diferente

La forma más rápida y fácil de personalizar Spring Boot es sobre escribir los valores de las propiedades predeterminadas.

Para el puerto del servidor, la propiedad que queremos cambiar es `server.port`.

De manera predeterminada, el servidor incorporado comienza en el puerto **8080**. Para cambiar el valor debemos agregar el archivo `application.properties` en el siguiente directorio `src/main/resources/application.properties` y agregar la siguiente línea:

> `server.port=8081`

## Probar el test de la aplicación

Para verificar si su aplicación funciona, debe escribir pruebas de unidad e integración para su aplicación. La clase de prueba en src / test / java / com / example / actuatorservice / ActuatorServiceApplicationTests.java asegura que

- Su controlador es receptivo.
- El endpoint de gestión es receptivo.

