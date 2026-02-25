FROM maven:3.5.4-jdk-11-alpine
COPY . .
RUN maven clean install
EXPOSE 8080
