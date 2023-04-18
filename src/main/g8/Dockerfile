FROM sbtscala/scala-sbt:graalvm-ce-22.3.0-b2-java17_1.8.2_2.13.10 as sbt-graalvm
WORKDIR /app
COPY . .

ENV LANG=C.UTF-8 LC_ALL=C.UTF-8
RUN sbt assembly

RUN gu install native-image
RUN native-image  \
    --no-fallback  \
    --enable-http  \
    --enable-https  \
    --static \
    -jar target/**/$name;format="camel"$.jar

FROM scratch
COPY --from=sbt-graalvm /app/$name;format="camel"$ /app/$name;format="camel"$
ENTRYPOINT ["/app/$name;format="camel"$", "-Xmx512m"]