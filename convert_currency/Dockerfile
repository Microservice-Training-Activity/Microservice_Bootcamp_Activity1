FROM eclipse-temurin:11-jre-alpine
ADD target/convert_currency-0.0.1-SNAPSHOT.jar convertcurrency.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar" , "convertcurrency.jar"]