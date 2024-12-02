FROM openjdk:17
from  maven:3.8.4-openjdk-17 as maven-builder

# Set the working directory in the container
WORKDIR /ac2

# Copy the JAR file into the container at /educacaoGamificada
COPY src /ac2/src
COPY pom.xml /AC2
COPY target/*.jar /ac2/app.jar

# Expose the port that your application will run on
EXPOSE 8585

# Specify the command to run on container start
ENTRYPOINT ["java", "-jar", "app.jar"]
CMD ["java", "-jar", "app.jar"]