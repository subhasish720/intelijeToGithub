FROM eclipse-temurin:17-jdk
WORKDIR /loan-app
EXPOSE 8081
COPY target/LoanManagementSystem-0.0.1-SNAPSHOT.jar loanApp.jar
ENTRYPOINT ["java", "-jar", "loanApp.jar"]