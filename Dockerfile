FROM openjdk:21-jdk-slim
LABEL authors="abakar"
# Install libfreetype6 and other font-related dependencies
RUN apt-get update && apt-get install -y \
    libfreetype6 \
    fontconfig \
    fonts-dejavu-core \
    && rm -rf /var/lib/apt/lists/*

# Set library path for freetype if needed
#ENV LD_LIBRARY_PATH=/usr/lib/x86_64-linux-gnu:$LD_LIBRARY_PATH

WORKDIR /app

COPY build/libs/attendance-service-1.0.0.jar  attendance-service.jar

# Copy wait-for-it.sh script
COPY ./wait-for-it.sh  app/wait-for-it.sh

# Make wait-for-it executable
RUN chmod  +x  app/wait-for-it.sh

# Command to execute the JAR, but it will be overridden by entrypoint in docker-compose.yml
ENTRYPOINT ["java", "-jar", "attendance-service.jar"]













