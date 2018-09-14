FROM java:8-jre
MAINTAINER Hiten Pratap Singh <hitenpratap99@gmail.com>

ADD ./build/libs/registry-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry-server-0.0.1-SNAPSHOT.jar"]

EXPOSE 8761