FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/silo_web-1.0.0-ALPHA.jar app.jar
COPY src/main/resources .

ENTRYPOINT ["java","-jar","/app.jar"]