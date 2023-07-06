FROM openjdk:latest
COPY ./target/coursework-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "coursework-0.1.0.1-jar-with-dependencies.jar"]