# First build stage: install dependencies
FROM maven:3.8.2-openjdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package

# Second build stage: run app
FROM openjdk:16-jdk-slim
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]