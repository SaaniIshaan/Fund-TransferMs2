FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/fund-transfer-app.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]docker