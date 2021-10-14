## APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES


APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES
Desarrolle una aplicación Web segura con los siguientes requerimientos:

Debe permitir un acceso seguro desde el browser a la aplicación. Es decir debe garantizar autenticación, autorización e integridad de usuarios.
Debe tener al menos dos computadores comunicacndose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado.
Explique como escalaría su arquitectura de seguridad para incorporar nuevos servicios.


## Autor ✒️


* **Jose María Castro Ortega** - *Autor*  - *Estudiante de ingeniería de sistemas*
* **21/06/2021** - *Fecha* 

## Tabla de contenido

- [Requisitos](#requisitos-).
- [Enunciado](#enunciado).
- [Video](#video)
- [Comenzando](#comenzando-).
- [Arquitectura](#arquitectura).
- [Productividad](#productividad).
- [Javadoc](#javaDoc-).
- [Licencia](#licencia-)


## Requisitos 📋
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Git](https://git-scm.com/) - Software de control de versiones
* [Java](https://www.oracle.com/java/) - Lenguaje de programación
* [Spark](http://sparkjava.com/) - Micro framework para crear aplicaciones web en Java 8

## Enunciado

APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES
Desarrolle una aplicación Web segura con los siguientes requerimientos:

Debe permitir un acceso seguro desde el browser a la aplicación. Es decir debe garantizar autenticación, autorización e integridad de usuarios.
Debe tener al menos dos computadores comunicacndose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado.
Explique como escalaría su arquitectura de seguridad para incorporar nuevos servicios.


## Video

[Video](https://github.com/Jose1102/AREP_SECURE/blob/main/Video.mp4)

## Comenzando 🚀
1. Clonar el repositorio
```
git clone https://github.com/Jose1102/AREP_SECURE
```

2. Compilar el proyecto

```
mvn package
```

3. Ejecutar el proyecto local

```
En el directorio Login

mvn exec:java -D "exec.mainClass"="co.edu.escuelaing.securityprimerlive.HelloLogin"

En tu navegador: https://localhost:4567

Email: jose.castro@mail.com
Password: 123456789

```

```
En el directorio Service

mvn exec:java -D "exec.mainClass"="edu.escuelaing.arep.service.app.App"



```

## Arquitectura

![arquitectura](https://github.com/Jose1102/AREP_SECURE/blob/main/images/arquitectura.PNG)


## Productividad
La productividad de este proyecto fue:
* 251 loc / 29 hours

## JavaDoc 📖

Para consultar la carpeta de [JAVADOC](https://github.com/Jose1102/AREP_SECURE/tree/main/Login/doc) del directorio Login.

Para consultar la carpeta de [JAVADOC](https://github.com/Jose1102/AREP_SECURE/tree/main/Service/doc) del directorio Service.


## Licencia 📌

Este proyecto está bajo la Licencia Pública General GNU - consulte el archivo de [LICENCIA](https://github.com/Jose1102/AREP_SECURE/blob/main/LICENSE.txt) para obtener más detalles.


