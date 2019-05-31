FROM azul/zulu-openjdk-alpine:11 as packager

ENV JAVA_MINIMAL=/opt/jre
#
## build modules distribution
RUN jlink \
    --verbose \
    --module-path "$JAVA_HOME/jmods" \
    --add-modules java.base,java.logging,java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument,jdk.management \
    --compress 2 \
    --no-header-files \
    --no-man-pages \
    --strip-debug \
    --output "$JAVA_MINIMAL"

# FROM node:10 as frontbuilder

# COPY "./" "/build"
# RUN { \
#         rm -rf /build/node_modules/ ; \
#         cd /build ; \
#         npm i && npm run build -- --prod ; \
#     }

FROM maven:3-jdk-11 as backendbuilder

COPY "./backend" "/build"
# COPY --from=frontbuilder "/build/dist" "/build/src/main/resources/static"

RUN { \
        cd /build ; \
        mvn install -DskipTests=true ; \
    }

# EXPOSE 8080
# CMD ["java","-jar","/build/target/backend-0.0.1-SNAPSHOT.jar"]

# Last stage, add only our minimal "JRE" distr and our app
FROM alpine

ENV JAVA_MINIMAL=/opt/jre
ENV PATH="$PATH:$JAVA_MINIMAL/bin"

COPY --from=packager "$JAVA_MINIMAL" "$JAVA_MINIMAL"
COPY --from=backendbuilder "/build/target/backend-0.0.1-SNAPSHOT.jar" "/app.jar"

EXPOSE 8080
CMD [ "-jar", "/app.jar", "--spring.config.location=classpath:/application-docker.properties"]
ENTRYPOINT [ "java" ]
