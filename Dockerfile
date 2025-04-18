FROM openjdk:17-jdk

WORKDIR /app

COPY target/devops-0.0.1-SNAPSHOT.jar /app/devops-back.jar

EXPOSE 8080

CMD ["java", "-jar", "devops-back.jar"]