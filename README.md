# API de de viajes CabRide

_Esta API se ancarga de manejar la informacion de viajes._

## Comenzando 🚀

_Estas instrucciones te permitirán que el proyecto funcione en una máquina local para propósitos de desarrollo y pruebas._

### Pre-requisitos 📋

_Que cosas necesitas para probar el proyecto_

```
- Base de datos PostgreSQL.
- IDE IntelliJ IDEA o similar.
- JDK Java 8.
```

### Instalación 🔧

_Rpimero debes de ambientar el entorno para las pruebas_

_Configura_

```
- Crea la base de datos "cabridedb".
- Restaurar la base de datos "cabridedb.backup" que se encuentra en la carpeta resources del proyecto.
- Configurar el "application.properties" del proyecto, cambiar contraseña y usuario segun corresponda.
```

## Ejecutando las pruebas ⚙️

_Ejecuta el proyecto Spring Boot_

### Pruebas🔩

_Debes de utilizar los siguientes endpoints_

```
- Metodo Get:
    -localhost:8090/cabride/v1/totalTrips
        *Consultar la cantidad de viajes totales.
    -localhost:8090/cabride/v1/totalTripsCity/{city}
        *Consultar la cantidad de viajes totales por ciudad.
    -localhost:8090/cabride/v1/totalTripsCountry/{country}
        *Consultar la cantidad de viajes totales por país.
    -localhost:8090/cabride/v1/currentTrips
        *Consultar los viajes actuales.
- Metodo Post:
    -localhost:8090/cabride/v1/saveTrip
        *Crear un viaje.
- Metodo Put:
    -localhost:8090/cabride/v1/updateTrip/{id}
        *Actualizar un viaje.
```

## Construido con 🛠️

_Las herramientas que se utilizo para crear el proyecto_


* [Spring Boot](https://start.spring.io/) - El framework web usado
* [Spring Data y JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) - Persistencia de datos
* [Lombok](https://projectlombok.org/) - Genera ese código repetitivo por nosotros
* [Maven](https://maven.apache.org/) - Manejador de dependencias

## Expresiones de Gratitud 🎁

* Gracias  🤓.



---
⌨️ con ❤️ por [mhuahuacondori](https://github.com/mhuahuacondori) 😊