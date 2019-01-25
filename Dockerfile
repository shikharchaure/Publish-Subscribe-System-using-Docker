FROM openjdk:8
ADD target/docker2.war docker2.war
EXPOSE 8081
ENTRYPOINT ["java","-jar","docker2.war"]
