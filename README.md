# java-spring-jwt-hibernate-mysql
A demo application with an authenticated  Spring Restful API via JWT with a simple MySql Persistance layer using JDBC and Hibernate.

# Resources

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




# Create Db.

The databased selected was Mysql. If you have the MySql shell configured on your 
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

5. Run TimesheetSeedApplication. You do this by going to:

    `..\samplejavaapi\seeders\TimesheetSeedApplication.java`
 
   This will read from the input from the provided .csv, reset the table, and then bulk import the timesheets into the database.

6. Run tests.




[ReadMe Reference Guide](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)