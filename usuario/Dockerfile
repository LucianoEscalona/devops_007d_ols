# Stage 1
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2
FROM eclipse-temurin:21-jdk AS runner
LABEL org.opencontainers.image.source="https://github.com/LucianoEscalona/devops_007d_ols"
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]