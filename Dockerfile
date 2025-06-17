# Gunakan base image Java 17
FROM openjdk:17-jdk-slim

# Tambahkan label untuk metadata
LABEL maintainer="namamu@email.com"

# Set direktori kerja di dalam container
WORKDIR /app

# Copy jar file hasil build ke container
COPY target/*.jar app.jar

# Jalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]
