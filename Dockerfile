FROM openjdk:12-alpine

MAINTAINER lsz-blog

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="" \
    PORT=9092 \
    PROFILES="default"

ADD /target/*.jar /lsz-blog-executable.jar

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /lsz-blog-executable.jar --spring.profiles.active=$PROFILES"]

EXPOSE $PORT
