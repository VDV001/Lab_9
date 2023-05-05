FROM openjdk:17

LABEL mentainer="javaguides.net@gmail.com"

WORKDIR /app

COPY target/springboot-restful-webservices.jar-1.jar /app/springboot-restful-webservices.jar-1.jar

CMD ["java", "-jar", "springboot-restful-webservices.jar-1.jar"]
