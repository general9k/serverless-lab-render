# Stage 1
FROM openjdk:17-slim AS builder
WORKDIR /app
COPY . .
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# Stage 2
FROM openjdk:17-slim
WORKDIR /app
COPY --from=builder /app/target/lab_4-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]