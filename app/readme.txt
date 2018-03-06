To start the application with the local Spring profile (which reads in the application-local.properties) : 

java -Dspring.profiles.active=local -jar target/testapp1-app-0.1-SNAPSHOT.jar

or 

mvn clean package spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=local"
