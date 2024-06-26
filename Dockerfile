FROM openjdk:17-alpine AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17-alpine
WORKDIR todo
COPY --from=build target/*.jar todo.jar
ENTRYPOINT ["java", "-jar", "todo.jar"]