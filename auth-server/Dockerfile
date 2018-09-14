FROM java:8-jre
MAINTAINER Hiten Pratap Singh <hitenpratap99@gmail.com>

ADD ./build/libs/auth-server-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/auth-server-0.0.1-SNAPSHOT.jar"]

EXPOSE 5000