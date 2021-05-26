FROM openjdk:17-jdk-alpine
MAINTAINER Garbi Ozyildiz
EXPOSE 8080
ADD target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]