FROM maven:3.8.1-openjdk-17
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src

ARG SERVER_PORT=9090
EXPOSE ${SERVER_PORT}
CMD ["java", "-jar", "target/RestaurantsService-0.0.1-SNAPSHOT.jar", "--server.port=${SERVER_PORT}"]
