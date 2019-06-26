FROM maven:3.6-jdk-11-slim as builder

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests -P openshift

FROM adoptopenjdk/openjdk11:alpine-jre
RUN apk add --no-cache curl
RUN curl -fsSLk https://github.com/stedolan/jq/releases/download/jq-1.6/jq-linux64 -o /usr/local/bin/jq
RUN chmod a+x /usr/local/bin/jq
COPY --from=builder /app/target/application.jar /
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/application.jar"]

