FROM java:8-alpine

RUN mkdir -p /app

COPY target/scala-2.11/*.jar /app/

WORKDIR /app

CMD java -jar ./$name;format="camel"$.jar
# override CMD from your run command, or k8s yaml, or marathon json, etc...

