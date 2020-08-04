FROM gradle:6.5.0-jre14 AS build

WORKDIR /build/desafio

COPY --chown=gradle:gradle . /build/desafio

RUN gradle build --no-daemon --console verbose
RUN ls -la /build/desafio/build/libs

FROM openjdk:14.0.1-jdk-oraclelinux7

COPY --from=build /build/desafio/build/libs/desafio-*.jar ./desafio.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar","desafio.jar" ]