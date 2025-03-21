# ======= stage 1: build stage ==========
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# ============ stage 2: Runtime Stage ======
FROM eclipse-temurin:17-jre
WORKDIR /app

RUN groupadd -r appgroup && useradd -r -g appgroup appuser
USER appuser

COPY --from=build /app/target/project01-1.0.0.jar app.jar

EXPOSE 8080

ENV DB_USER=root
ENV DB_URL=jdbc:mysql://host.docker.internal:3306/project01?createDatabaseIfNotExist=true&serverTimezone=UTC
ENV DB_PASS=

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

