# Base image for the Docker container
FROM openjdk:16

# Copy the JAR file from the local directory to the /tmp directory inside the container
COPY ./target/devops.jar /tmp

# Set the working directory to /tmp
WORKDIR /tmp

# Set the entry point for the container to run the JAR file using the java command
ENTRYPOINT ["java", "-jar", "devops.jar", "db:3306", "30000"]


