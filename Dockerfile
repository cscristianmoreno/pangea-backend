FROM eclipse-temurin:21-alpine

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} pangea.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/pangea.jar"]