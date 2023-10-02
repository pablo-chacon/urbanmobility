FROM openjdk:17
COPY ./out/production/DockerMaaSp/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","MaasfpApplication"]