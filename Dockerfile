FROM openjdk:17

# Set the working directory in the container
WORKDIR /ac2-integra

# Copy the JAR file into the container at /educacaoGamificada
COPY target/*.jar /ac2_ca/ac2_ca-0.0.1-SNAPSHOT.jar

# Expose the port that your application will run on
EXPOSE 8585

# Specify the command to run on container start
CMD ["java", "-jar", "teste-unidade-2-0.0.1-SNAPSHOT.jar"]