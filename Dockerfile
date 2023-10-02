FROM openjdk:17
COPY ./out/production/DockerMaasfpApplication/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","MaasfpApplication"]