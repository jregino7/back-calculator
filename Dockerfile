FROM openjdk:latest

RUN mkdir -p /usr/src/myapp
WORKDIR /usr/src/myapp
COPY  build/libs/Calculator-0.0.1-SNAPSHOT.jar calculadora.jar


CMD ["java", "-jar", "calculadora.jar"]


EXPOSE 8080