# Stage 1: сборка
FROM openjdk:17-jdk-slim AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Stage 2: финальный образ
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=builder /app/target/lab_4-*.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "app.jar"]