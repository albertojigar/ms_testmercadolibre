FROM openjdk:11-jdk-slim
MAINTAINER 'albertojigar@gmail.com'
COPY /applications/app-service/build/libs/app-service.jar /opt/app-service.jar
env SPRING_PROFILES_ACTIVE='dev'
env LOG4J_LEVEL='INFO'
env APIC_TIMEOUT=3000
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Xms256m", "-Xmx256m", "-jar", "/opt/app-service.jar"]