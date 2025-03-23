#MODEL IMAGE
FROM eclipse-temurin:17.0.14_7-jdk

#PORT INFORM
EXPOSE 8080

#ROOT FOLDER
WORKDIR /root

#COPY & PASTE
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

#DOWNLOAD DEPENDENCIES
RUN chmod +x /root/mvnw
RUN ./mvnw dependency:go-offline

#COPY CODE PROJECTE
COPY ./src /root/src

#BUILD APP (without tests)
RUN ./mvnw clean install -DskipTests

#UP APP
ENTRYPOINT ["java", "-jar", "/root/target/RegistreComptable-1.0.0.jar"]
