FROM openjdk:17
VOLUME /tmp
EXPOSE 8090
ARG JAR_FILE=target/jukebox-0.0.1.jar
ADD ${JAR_FILE} app.jar
ADD src/main/resources/application.yaml application.yaml
ENTRYPOINT ["java","-jar","/app.jar"]
