FROM openjdk:8-jdk-alpine
ENV TZ='GMT-3'
VOLUME /tmp
EXPOSE 8089
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} catalogo-produto.jar
ENTRYPOINT ["java","-Xmx512M","-jar","catalogo-produto.jar"]
