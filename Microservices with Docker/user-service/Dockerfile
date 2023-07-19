FROM openjdk:8

EXPOSE 9001

ADD /target/user-service-0.1.jar user-service.jar

ENTRYPOINT ["java","-jar","user-service.jar"]