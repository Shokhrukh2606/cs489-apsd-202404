# Using OpenJDK version 17 as the base image
FROM openjdk:21
# Create a new app directory in the container for the application files
RUN mkdir /app
# Copy the compiled executable files/folders from host machine filesystem to the container/image's filesystem
COPY target/appointmentmanagementapp-0.0.1-SNAPSHOT.war /app
# Set the working directory for where next commands will execute at
WORKDIR /app
# Define the command to run the app when the contain is started
CMD ["java", "-jar", "./appointmentmanagementapp-0.0.1-SNAPSHOT.war"]
