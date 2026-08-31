FROM amazoncorretto:21-alpine-jdk

LABEL maintainer="tu-equipo@ebc.edu.mx"
LABEL description="Imagen base con Java 21 (Corretto) y dependencias del sistema"

RUN apk update && \
    apk add --no-cache \
        bash \
        curl \
        tzdata \
    && rm -rf /var/cache/apk/*

ENV TZ=America/Mexico_City

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app
