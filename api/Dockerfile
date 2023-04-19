FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar api.jar
ENTRYPOINT ["java","-jar","/api.jar"]