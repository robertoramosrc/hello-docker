FROM openjdk:11
RUN mkdir /tmp/betaum
ADD . /tmp/betaum
RUN chmod +x /tmp/betaum/gradlew
WORKDIR /tmp/betaum
RUN ls /tmp -lsah
RUN ls -lsah
RUN ./gradlew clean build
RUN ls /tmp/betaum/build/libs/*.jar -lsah
RUN mv /tmp/betaum/build/libs/*.jar /tmp/app.jar

FROM eclipse-temurin:11
COPY --from=0 /tmp/app.jar /tmp
RUN ls /tmp
ENTRYPOINT ["java", "-jar", "/tmp/app.jar"]
EXPOSE 9095
