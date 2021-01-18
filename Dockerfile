FROM maven:3-openjdk-8-slim as MAVEN_BUILD
WORKDIR /application
COPY pom.xml /application/
COPY src /application/src/
RUN mvn package


# the second stage of our build will use open jdk 8 on alpine 3.9
#FROM openjdk:8-jre-alpine3.9
 
# copy only the artifacts we need from the first stage and discard the rest
#COPY --from=MAVEN_BUILD /application/target/*SNAPSHOT.war /application.war
#EXPOSE 8084
# set the startup command to execute the jar
#CMD ["java", "-jar", "/application.jar"]
#CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/application.war"]

FROM tomcat:9.0-jre8-alpine 
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/
EXPOSE 8080
COPY --from=MAVEN_BUILD /application/target/*.war /usr/local/tomcat/webapps/
