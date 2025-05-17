FROM openjdk:21
WORKDIR /app
COPY . .
RUN ./gradlew build
CMD ["./gradlew", "test"]
