FROM openjdk:15
VOLUME /tmp
ADD ./target/retos-estadisticas-0.0.1-SNAPSHOT.jar estadisticas.jar
ENTRYPOINT ["java","-jar","/estadisticas.jar"]