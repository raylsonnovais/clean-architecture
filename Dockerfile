FROM gradle:7.5.0-jdk17 as build
WORKDIR /app
COPY build.gradle settings.gradle /app/
COPY src /app/src
RUN gradle build --no-daemon

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
