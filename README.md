# springboot-jukebox-app

This app supports a REST API with a single GET endpoint which returns a paginated list of jukeboxes that suppport a given setting id.

## Requirements

For building and running the application you need:

- [JDK 17](https://jdk.java.net/17/)
- [Maven 3](https://maven.apache.org)

or 

- [docker](https://www.docker.com/products/docker-desktop/)
## Running the application

One way is to execute the `main` method in the `src/main/java/com/example/jukebox/JukeboxApplication.java` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
Or you can use docker 
### Docker

This application is also available on [Dockerhub Registry](https://hub.docker.com/repository/docker/mohaddesezohourian/jukebox/general):

```shell
docker run -p 8090:8090 mohaddesezohourian/jukebox:latest
```

## API Documentation

If you want to access the api documentation you can use below link after running the project:

```shell
http://localhost:8091/swagger-ui/index.html
```



