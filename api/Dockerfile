FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
VOLUME /tmp
#COPY target/*.jar app.jar

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw install -DskipTests

ENTRYPOINT ["java","-jar","target/app.jar"]