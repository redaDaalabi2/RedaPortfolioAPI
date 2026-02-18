# ---------- BUILD ----------
FROM eclipse-temurin:18-jdk-jammy AS builder
WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# ---------- RUN ----------
FROM eclipse-temurin:18-jre-jammy
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
