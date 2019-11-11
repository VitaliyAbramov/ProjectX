FROM openjdk:8-jdk-alpine

LABEL maintainer="Vitalii Abramov" \
      email="vabram@softserveinc.com" \
      version="1.0" \
      description="ProjectX-Phase1"

# Path where spring boot app creates derictories for Tomcat by default
VOLUME /tmp
# Add jar file to the container
ADD target/mark1-1.0-SNAPSHOT.jar app.jar

# Run the jar file in the container
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
