FROM openjdk:11
WORKDIR /app
EXPOSE 8080
RUN apt-get update
RUN apt install git -y
RUN apt install maven -y
RUN git clone https://github.com/lgomesb/learning-spring-mongodb.git
RUN mvn clean package -DskipTests -f /app/learning-spring-mongodb/customer-maintainer/pom.xml
RUN cp /app/learning-spring-mongodb/customer-maintainer/target/customer-maintainer-1.0.0.jar /app/customer-maintainer.jar
RUN rm -R /app/learning-spring-mongodb
RUN rm -R /root/.m2/repository/
RUN apt-get remove  maven -y
RUN apt-get remove  git -y
ENTRYPOINT ["java","-jar","/app/customer-maintainer.jar"]
# RUN apt-get install openjdk-11-jdk -y