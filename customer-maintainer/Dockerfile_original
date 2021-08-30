FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/customer-maintainer-1.0.0.jar customer-maintainer.jar
ENTRYPOINT ["java","-jar","/customer-maintainer.jar"]