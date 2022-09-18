FROM eclipse-temurin
EXPOSE 8080
ADD target/brateckapi-0.0.1-SNAPSHOT.jar bratecapi.jar
ENTRYPOINT [ "java", "-jar", "bratecapi.jar" ]