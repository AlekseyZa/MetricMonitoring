FROM maven:3.9.0-amazoncorretto-17 as build
COPY pom.xml /build/
WORKDIR /build/
COPY src /build/src/
RUN mvn package -DskipTests

FROM openjdk:17-alpine
ARG JAR_FILE=/build/target/*.jar
COPY --from=build $JAR_FILE /opt/docker-st2/producerapp.jar
ENTRYPOINT ["java","-jar","/opt/docker-st2/producerapp.jar"]

