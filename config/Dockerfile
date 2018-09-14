FROM java:8-jre
MAINTAINER Hiten Pratap Singh <hitenpratap99@gmail.com>

ADD ./build/libs/config-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-0.0.1-SNAPSHOT.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://127.0.0.1:8888/actuator/health || exit 1

EXPOSE 8888