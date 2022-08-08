FROM maven:3.8.6-eclipse-temurin-17-alpine AS builder
COPY pom.xml pom.xml
COPY src src/
RUN mvn clean package

FROM openjdk:17-oracle
COPY --from=builder target/hlt-bmr-calc-service-0.0.1-SNAPSHOT.jar hlt-bmr-calc-service-0.0.1-SNAPSHOT.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "hlt-bmr-calc-service-0.0.1-SNAPSHOT.jar"]