FROM adoptopenjdk:11-jre-hotspot
ADD ./target/k8s-0.0.1-SNAPSHOT.jar   /hello-k8s.jar
EXPOSE 9901
ENTRYPOINT ["java","-jar","/hello-k8s.jar"]