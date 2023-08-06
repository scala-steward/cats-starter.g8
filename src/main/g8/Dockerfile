FROM eclipse-temurin:20 as coursier
WORKDIR /coursier

RUN curl -fLo coursier https://github.com/coursier/launchers/raw/master/coursier && \
    chmod +x coursier && \
    ./coursier setup -y

ENV PATH="/root/.local/share/coursier/bin:\${PATH}"

FROM coursier as sbt
WORKDIR /scratch

COPY . .
RUN sbt assembly

FROM ghcr.io/graalvm/native-image:22 as builder
WORKDIR /scratch
COPY --from=sbt /scratch/target/**/app.jar .

RUN native-image  \
    --no-fallback  \
    --enable-http  \
    --enable-https  \
    --static \
    -jar app.jar

FROM scratch as runner
WORKDIR /app
COPY --from=builder /scratch/app .

ENTRYPOINT ["/app/app"]