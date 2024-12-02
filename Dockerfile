FROM openjdk:17
from  maven:3.8.4-openjdk-17 as maven-builder

# Set the working directory in the container
WORKDIR /AC2

# Copy the JAR file into the container at /educacaoGamificada
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests
FROM openjdk:17-alpine
COPY target/*.jar /AC2/teste.jar

# Expose the port that your application will run on
EXPOSE 8585

# Specify the command to run on container start
CMD ["java", "-jar", "teste.jar"]