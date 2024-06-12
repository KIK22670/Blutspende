# Use the official gradle image to build the app
FROM gradle:6.8.3-jdk8 as builder

# Copy local code to the container image
COPY . /home/gradle/project

# Set the working directory
WORKDIR /home/gradle/project

# Build the app
RUN gradle build

# Use the official openjdk image for running the app
FROM openjdk:8-jre-alpine

# Copy the built app from the builder stage
COPY --from=builder /home/gradle/project/build/libs /app

# Set the working directory
WORKDIR /app

# Command to run the app (if you have a runnable jar)
CMD ["java", "-jar", "Blutspendekompabilitaetsapp.jar"]