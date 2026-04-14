FROM openjdk:17-jdk-slim
WORKDIR /loan-app
EXPOSE 8081
COPY target/LoanManagementSystem-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]