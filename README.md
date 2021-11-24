# PEN PINEAPPLE APPLE PEN (PPAP)

## Backend en SpringBoot
El backend fue desarrollado con SpringBoot. 

#### Desarrollado por:
- [Lucía Paulina Pereyra](https://github.com/luciapaulinapereyra) - Backend
- [Alejandra Adrian Tejada](https://github.com/ale-drian) - FrondEnd
- [Mariam Apaza Santillana](https://github.com/mapaza) - FronEnd
- [Ariadna Eyzaguirre Cuellar](https://github.com/ariaeyza) - Diseño
- [Sheyla Breña Sicha](https://github.com/ariaeyza) - Diseño

## Resultados

| Entregable | Ubicacion |
| ------ | ------ |
| Backend | https://github.com/luciapaulinapereyra/pineapple-app-back |
| Frontend |https://github.com/ale-drian/pineapple-app-front |
| API | https://heroku |
| Base de Datos | https://holi |
| Applicacion WEB | https://heroku |



## Installation
Clonar el proyecto y correr 
```sh
git clone https://github.com/luciapaulinapereyra/pineapple-app-back
cd pineapple-app-back
mvnw spring-boot:run
```

## Requerimientos
##### Java Version:
Versión de Java usada, 11, pero se puede cambiar en el archivo pom.xml
```sh
    <properties>
		<java.version>11</java.version>
	</properties>
```

##### Base de datos:
La base de datos utilizada es MYSQL, si se desea agregar la dependencia del conector en el archivo pom.xml
```sh
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<scope>runtime</scope>
	</dependency>
```
La conexion a la base de datos, puede ser local o en la nube, se debe especificar en:
```sh
	cd src/main/resources/application.properties
	// Nombre de la base de datos
	spring.datasource.url=jdbc:mysql://localhost:3306/pineapple_db
	// Usuario de la base de datos
    spring.datasource.username=root
    // Contraseña de la base de datos
    spring.datasource.password=
```
