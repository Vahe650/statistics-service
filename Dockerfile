FROM openjdk:17-jdk-alpine AS build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean package -DskipTests
RUN wget -O dd-java-agent.jar https://dtdg.co/latest-java-tracer

FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp
ARG JAR_FILE=/workspace/app/target/*.jar
ARG DD_FILE=/workspace/app/dd-java-agent.jar
COPY --from=build ${JAR_FILE} app.jar
COPY --from=build ${DD_FILE} dd-java-agent.jar
ARG VERSION
ENV DD_VERSION=$VERSION
ENTRYPOINT ["java", "-javaagent:dd-java-agent.jar", "-XX:MaxRAMPercentage=70.0", "-jar", "app.jar"]