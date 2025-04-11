# Etapa 1: Usar uma imagem base com o JDK
FROM openjdk:17-jdk-slim as build

# Diretório de trabalho no contêiner
WORKDIR /app

# Copiar o arquivo JAR do Spring Boot para dentro do contêiner
COPY target/softweek-0.0.1-SNAPSHOT.jar /app/softweek.jar

# Expor a porta que o Spring Boot vai rodar
EXPOSE 8081

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/softweek.jar"]
