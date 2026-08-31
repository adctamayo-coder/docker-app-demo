FROM myapp-base:1.0

USER root

COPY src/ /app/src/

RUN mkdir -p /app/classes && \
    javac -d /app/classes /app/src/com/example/App.java

RUN chown -R appuser:appgroup /app

USER appuser

WORKDIR /app

EXPOSE 8081

ENTRYPOINT ["java", "-cp", "classes", "com.example.App"]
