FROM openjdk:8

EXPOSE 9002

ADD /target/product-service-0.1.jar product-service.jar

ENTRYPOINT ["java","-jar","product-service.jar"]