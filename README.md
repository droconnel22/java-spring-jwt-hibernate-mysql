# java-spring-jwt-hibernate-mysql
A demo application with an authenticated  Spring Restful API via JWT with a simple MySql Persistance layer using JDBC and Hibernate.

## Getting Started

The database selected was Mysql. If you have the MySql shell configured on your 
local machine you can run the following commands. 

Open a cmd or bash shell and run the following commands:

1. Log in to MySql:  

        `mysql -u root -p`

2. Create Timesheet Database:

        `mysql> CREATE DATABASE timesheetdb2;`
        
3. Create User to access:

        `mysql> create user 'demouser'@'%' identified by 'giant123';`
        
4. Grant privileges to created user:
    
        `mysql> grant all on timesheetdb.* to 'demouser'@'%';`

5. Now you are ready to run the application. Navigate to the project root directory which contains the pom.xml
and mvn executables. Enter in the command line:

        `java-spring-jwt-hibernate-mysql> mvn spring-boot:run`
 
   This will read from the input from the provided .csv, reset the table, and then bulk import the timesheets into the database.



## Running tests

Cucumber Js was used to show case the power of Acceptance testing. 5 Scenarios where defined:

* Get All Timesheets
* Get Existing Timesheet by Id
* Get Existing Timesheet By Search Criteria of client
* Create a new Timesheet
* Update an existing Timesheet

Running the acceptance test requires that the API server be running and connected to the MySql db. 
If the database is empty seeding will happen automatically otherwise seeding is skipped. The
database is always checked on each server start up. 

To start the server independently first run:

    `mvn spring-boot:run`
    
Then to run the acceptance test with the UI, navigate to:

    `test\java\resources\timesheet.feature`

And hit run. If running IntelliJ with Cucumber and Gherkin Plugins then you can do
this directly and enjoy a nice UI experience. 
    
Or for a command line only navigate to root directory with POM.xml file and enter:

    `mvn clean test -Dcucumber.options="src/resources/timesheet.feature"`   


### General Thoughts.

This is the developers first EVER Java Spring Rest API. This was done on 
purpose as learning exercise and to explore the opinions and benefits into the Java
Spring approach. Also MySQL was another database not used by the author developer
in several years, but was chosen due to its ubiquity and natrual fit for the
Spring ecosystem. MySQL itself is powerful freetier SQL database competitor and
refreshment of applications framewoks as well as database technologies should be
encouraged.

### Data Layer

The data layer chosen is MySQL with JDBC Hibernate and Spring Data. This layer is 
highly abstracted away, more so then most other frameworks. Only one class 
exists at this tier, the Timesheet Repository. This is an interface only that
implmenents a CRUD Repostiory, where the object and type for an Id is specified.
In a highly black box approach custom query methods are merely declared and magic
happens behind the scenes that wires it all up. Configurations and databasemigrations
are also very black boxed, with requiring the developer to not specify much.


### Seeding Layer

Leveraging the order of operations, and the naive approach. The developer chose
to take advantage of the dependency injection of the Spring framework and do
an eager database loading approach as the first step after all object mappings
are completed. This is known as the InitalizingBean Interface.

A seeding strategy was introduced. For each server start up the database is checked if the count is 588. If the count is 
less or even 0 then it is assumed the database is in a corrupted state (as this is a demo app) and will repopulate the table 
or even create a new migration and seed if the table does not exist.


### Domain Layer

This layer includes a singular class Timesheet that is used as both the 
database entity, domain object, and data transfer object. Due to the trival
nature of this exercise, this 3 use case would be discouraged in a production 
environment. In Java a code smell of this is the exceeding number of annotations
placed on each property indicating that several different uses will add to 
unrecoverable complexity. While in production enterprise a single use model
is highly bad practice, here in a small case, the power of the modern Java API's
is brought forth. Starting with a single model a developer can integrate a property
for validations, constraints, conversations to Json, Swagger documentation, and even
Data Entity migrations.


### API/Infrastructure Layer  

Spring Rest controllers really show case the benefits of the framework. In a short amount of code dependency injection, 
routing, request handling, validation, response types are effectively handled. This developer was left with a surprised
feeling at the low requirement of actual code. However each annotation requires a large amount of knowledge and hides a
significant amount of boilerplate code and logic. Spring almost works too well, leaving the developer with a feeling of
greater confidence then warranted.


### Json Web Token / Authentication

For this purposes, this was left for a future to do in favor of a more robust testing apparatus. However
research shows that the benefits of Spring, and Spring Security are lacking in this area and the abundance of
verbose boiler code is very apparent. Some references below were included for those interested.
 
 
## Evidence of Completion

A set of meaningful images has been included to prove successful testing on the authors end.
To see these pictures navigate to:

        `src\main\resources\*.png`

These pictures include successful MySql seeding, successful integration with Postman, and most importantly 5 successfully
passing scenarios.   
 



### Resources

* https://github.com/szerhusenBC/jwt-spring-security-demo
* https://www.baeldung.com/persistence-layer-with-spring-and-hibernate
* https://www.journaldev.com/3531/spring-mvc-hibernate-mysql-integration-crud-example-tutorial#hibernate-entity-bean
* https://www.javaspringclub.com/spring-mvc-hibernate-mysql-example/#repository
* http://spring.io/projects/spring-data-jpa#samples
* https://spring.io/understanding/REST
* https://medium.com/omarelgabrys-blog/microservices-with-spring-boot-authentication-with-jwt-part-3-fafc9d7187e8
* https://spring.io/guides/gs/accessing-data-mysql/
* https://www.baeldung.com/spring-boot-command-line-arguments
* https://stackoverflow.com/questions/41563779/how-to-autowire-spring-data-crudrepository





[ReadMe Reference Guide](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)