## Use the latest MySQL image
#FROM mysql
## Set the working directory
#WORKDIR /tmp
## Copy all the files to the working directory of the container
#COPY *.sql /tmp/
## Copy the main SQL file to docker-entrypoint-initdb.d.
## Scripts and SQL files in this folder are executed on container startup.
## This is specific to MySQL.
#COPY world.sql /docker-entrypoint-initdb.d
## Set the root password
#ENV MYSQL_ROOT_PASSWORD example

FROM openjdk:latest
COPY ./target/seMethods.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods.jar", "db:3306", "30000"]
