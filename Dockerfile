# Usar una imagen de OpenJDK para Spring Boot
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por Maven o Gradle
COPY target/InterviewTest-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que corre la aplicación (ajústalo según sea necesario)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-Dspring.profiles.active=docker","-jar", "app.jar"]
