FROM frolvlad/alpine-oraclejdk17:slim
EXPOSE 8080
RUN mkdir -p /app/
ADD target/tg-data-client-0.0.1-SNAPSHOT.jar /app/tg-data-client.jar
ENTRYPOINT ["java", "-jar", "/app/tg-data-client.jar"]