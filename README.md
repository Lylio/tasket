![](https://github.com/Lylio/image-repo/blob/master/logos/spring-boot.png?raw=true)
![](https://github.com/Lylio/image-repo/blob/master/logos/react.png?raw=true)
![](https://github.com/Lylio/image-repo/blob/master/logos/postgres.png?raw=true)

# Tasket

### Description
A task board featuring drag 'n' drop functionality.

### Tech Stack
- Spring Boot (JDK 11)
- React
- PostgreSQL

### Setup & Launch
This app includes the plugins _frontend-maven-plugin_ and _maven-resources-plugin_. This enables the Spring Boot
backend and React frontend to be packaged into a single JAR which runs both components together on a single port.

The app requires a local PostgreSQL database to be active in order to launch.

#### Database
1. Update the `src/main/resources/application.properties` file to reflect the PostgreSQL username and password details used by
your local instance of PostgreSQL
2. Create a database called 'tasket' (accessible at localhost:5432) using **psql** or a database IDE:  
   `CREATE DATABASE tasket`

The necessary table and column values will be auto-created by Hibernate when the app starts.

#### Maven Launch
1. Navigate to the root directory (where pom.xml is)
2. Run `mvn clean package` which will create an uber-JAR
3. Run the JAR with `java -jar target/tasket-0.0.1-SNAPSHOT.jar`
4. Open browser at http://localhost:8080


