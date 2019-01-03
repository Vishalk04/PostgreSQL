FROM java:alpine
VOLUME /tmp
ADD target/postgresql.jar postgresql.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","postgresql.jar"]