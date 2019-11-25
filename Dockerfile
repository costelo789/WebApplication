# Use an official Python runtime as a parent image
FROM openjdk:8-jdk-slim

# Set the working directory to /app
WORKDIR /webrest

# Copy the current directory contents into the container at /app
COPY . /webrest

# Install any needed packages specified in requirements.txt
RUN apt-get update
RUN apt-get install maven -y
RUN apt-get install mysql-server -y


# Make port 80 available to the world outside this container
EXPOSE 8080

# Define environment variable
ENV NAME World

# Run app.py when the container launches
#CMD ["python", "app.py"]
RUN ls
RUN mvn clean test
CMD ["mvn", "exec:java"]
