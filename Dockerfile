# First build stage: install dependencies
FROM maven:3.8.2-openjdk-11-slim AS build

WORKDIR /workspace

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


FROM eclipse-temurin:11-jre-jammy

WORKDIR /app

COPY --from=build /workspace/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
