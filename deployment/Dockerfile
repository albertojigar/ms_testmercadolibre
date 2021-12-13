FROM openjdk:x86_64-alpine-jdk-11.0.11_9-slim
MAINTAINER 'albertojigar@gmail.com'
COPY build/libs/ms-testmercadolibre-1.0-SNAPSHOT.jar /opt/ms-testmercadolibre-1.0-SNAPSHOT.jar
env SPRING_PROFILES_ACTIVE='dev'
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Xms256m", "-Xmx256m", "-jar", "/opt/ms-testmercadolibre-1.0-SNAPSHOT.jar"]