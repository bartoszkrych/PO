# W Góry Application



## Table of contents
* [General info](#general-info)
* [Diagrams](#diagrams)
	* [Activity daigrams](#activity-diagrams)
	* [Sequence diagrams](#sequence-diagrams)
	* [Class diagram](#class-diagram)
* [Technologies](#technologies)
* [Setup](#setup)
* [Author](#author)

## General info
Student project - Software Design (Projektowanie oprogramowania).<br/>
Support for GOT (Górska Odznaka Turystyczna).

## Diagrams

### Activity diagrams
* Use case - Add a new <i>TrasaPunktowana</i> to database
![AD new TrasaPunktowana](https://user-images.githubusercontent.com/26009817/72386490-c3ffef80-3721-11ea-8e02-564c24d64088.jpg)
* Use case - Change of <i>Wycieczka</i> status to <i>Odbyta</i>
![AD set done your Wycieczka](https://user-images.githubusercontent.com/26009817/72386685-1c36f180-3722-11ea-9eca-05bcd27b6eee.png)
### Sequence diagrams

*  Use case - Add a new <i>TrasaPunktowana</i> to database
![DS new TrasaPunktowana](https://user-images.githubusercontent.com/26009817/72386491-c3ffef80-3721-11ea-8a1c-93c9c1eeebcb.jpg)
*  Use case - Change of <i>Wycieczka</i> status to <i>Odbyta</i>
![DS set done your Wycieczka](https://user-images.githubusercontent.com/26009817/72386489-c3675900-3721-11ea-93ea-507469b12120.jpg)
### Class diagram

![CD](https://user-images.githubusercontent.com/26009817/72386491-c3ffef80-3721-11ea-8a1c-93c9c1eeebcb.jpg)

<!-- ![ERD](https://user-images.githubusercontent.com/26009817/65752723-a7599080-e10d-11e9-9503-44228043d12b.jpg) -->
	
## Technologies
Project is created with:
* [JDK 11.0.5](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
* [Gradle 6.0.1](https://gradle.org/releases/)
* [Spring Boot 2.2.2](https://spring.io/projects/spring-boot)
* [Hibernate 2.1](http://hibernate.org/)
* [SQLite 3.8.11.2](https://www.sqlite.org/index.html)
* [Lombok](https://projectlombok.org/)
* [Swagger 2.9.2](https://swagger.io/)
* [Angular 8](https://angular.io/docs/)
* [Angular CLI 8.3.20](https://www.npmjs.com/package/@angular/cli/v/8.3.20)

## Setup

### Back-end(w-gory-java)

You need plugin in IDE [Lombok](https://plugins.jetbrains.com/plugin/6317-lombok/) by Michail Plushnikov.<br/>
[Instruction](https://github.com/mplushnikov/lombok-intellij-plugin#installation).<br/>
To run this project open WGoryApplication.java and then press Alt+Shift+F10.<br/><br/>
After run, You can open a [documentation](http://localhost:8080/swagger-ui.html)

### Front-end(w-gory-angular)

1. `npm install`
2. `ng serve`

for more information go to [w-gory-angular](https://github.com/bartoszkrych/PO/tree/master/w-gory-angular)

## Author

* [Bartosz Krych](https://github.com/bartoszkrych) 
