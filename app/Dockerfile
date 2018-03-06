FROM openjdk:8u92-jdk-alpine

# /tmp is where a Spring Boot application creates working directories for Tomcat by default
VOLUME /tmp

ENV APP_ARTIFACT_BASE_NAME testapp1
ENV APP_ARTIFACT_FINAL_NAME $APP_ARTIFACT_BASE_NAME.jar

RUN mkdir /app

ADD target/$APP_ARTIFACT_BASE_NAME*.jar /app/$APP_ARTIFACT_FINAL_NAME

# You can use a RUN command to "touch" the jar file so that it has a file modification time
# (Docker creates all container files in an "unmodified" state by default).
# This actually isnâ€™t important for the simple app that we wrote, but any static content (e.g. "index.html")
# would require the file to have a modification time.
RUN sh -c 'touch /app/$APP_ARTIFACT_FINAL_NAME.jar'

ENV JAVA_OPTS=""

# To reduce Tomcat startup time we added a system property pointing to "/dev/urandom" as a source of entropy.
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/$APP_ARTIFACT_FINAL_NAME" ]