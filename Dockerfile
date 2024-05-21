# FROM openjdk:latest

# RUN mkdir -p /usr/src/myapp
# WORKDIR /usr/src/myapp
# COPY  build/libs/Calculator-0.0.1-SNAPSHOT.jar calculadora.jar


# CMD ["java", "-jar", "calculadora.jar"]


# EXPOSE 8080



# Utiliza una imagen oficial de Gradle para construir la aplicación
FROM gradle:7.3.3-jdk17 AS build

# Crea el directorio de la aplicación en la imagen
WORKDIR /usr/src/app

# Copia los archivos del proyecto al contenedor
COPY --chown=gradle:gradle . .

# Construye la aplicación
RUN gradle build

# Utiliza una imagen de OpenJDK para la fase de ejecución
FROM openjdk:17-jdk-slim

# Crea el directorio de la aplicación en la imagen
WORKDIR /usr/src/app

# Copia el archivo JAR desde la etapa de construcción
COPY --from=build /usr/src/app/build/libs/Calculator-0.0.1-SNAPSHOT.jar calculadora.jar

# Expone el puerto 8080
EXPOSE 8080

# Define el comando por defecto para ejecutar la aplicación
CMD ["java", "-jar", "calculadora.jar"]
