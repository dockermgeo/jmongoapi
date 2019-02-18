FROM java

ENV VERSION=0.0.1
ENV PROJECT=mongojrest

COPY target/${PROJECT}-${VERSION}.jar /app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]
