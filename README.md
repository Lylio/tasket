<br >
<img src="https://img.shields.io/badge/-spring%20boot-white.svg?style=for-the-badge&logo=SPRING%20BOOT&logoColor=#6DB33F" style="zoom:150%"/>
<img src="https://img.shields.io/badge/-postgres-4169E1.svg?style=for-the-badge&logo=postgresql&logoColor=white" style="zoom:150%"/>
<img src="https://img.shields.io/badge/-angular-DD0031.svg?style=for-the-badge&logo=angular&logoColor=white" style="zoom:150%"/>


# Tasket

### Description
A task board featuring drag 'n' drop functionality. Demo can be found hosted on Heroku:  
https://tasket-demo.herokuapp.com

### Tech Stack
- Spring Boot (JDK 11)
- React
- PostgreSQL
- Maven
- Liquibase

### Setup & Launch
This app includes the plugins _frontend-maven-plugin_ and _maven-resources-plugin_. This enables the Spring Boot
backend and React frontend to be packaged into a single JAR which runs both components together on a single port.

The default Spring profile of the app runs using an H2 (in-memory) database. The **dev** Spring profile requires a local 
PostgreSQL database to be active in order to launch.

#### Database
1. Update the `src/main/resources/application.yml` file to reflect the database connection username and password details used by
your local instance of PostgreSQL
2. Create a database called 'tasket' (accessible at localhost:5432) using **psql** or a database IDE:  
   `CREATE DATABASE tasket`

The necessary table and column values will be auto-created by Liquibase when the app starts.

#### Maven Launch
1. Navigate to the root directory (where pom.xml is)
2. Run `mvn clean package` which will create an uber-JAR
3. Run the JAR with `java -jar target/tasket-0.0.1-SNAPSHOT.jar` (this is the **default** Spring profile)
4. Open browser at http://localhost:8080

#### Spring Profiles
There are two Spring profiles available with corresponding database config data: **dev** and **default**.

1. Create a JAR file with the command `mvn clean package` in the application's root folder
2. In the /target directory, run the JAR file and include the desired **dev** profile passed as an
   argument:

e.g. `java -jar -Dspring.profiles.active=dev tasket-0.0.1-SNAPSHOT.jar`

If the default H2 in-memory database is used, the H2 console can be reached at http://localhost:8080/h2/ and logged into with
- url: **jdbc:h2:mem:tasket**
- username: **tasket** 
- password: **tasket**

#### Docker Launch
1. `docker build -t tasket .`
2. `docker run -p 8080:8080 tasket:latest` (note: the port number *has* to be 8080)  
   (or to run the **dev** Spring profile)
3. `docker run -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=dev" tasket:latest`

