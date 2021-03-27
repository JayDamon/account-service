FROM gradle:6.8-jdk15 AS build
COPY --chown=gradle:gradle . /home/app/src
WORKDIR /home/app/src
RUN gradle build --no-daemon

FROM openjdk:15-jdk-buster
COPY --from=build /home/app/src/build/libs/*.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/usr/local/lib/app.jar"]
