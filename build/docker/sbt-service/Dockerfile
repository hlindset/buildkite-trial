FROM openjdk:jre-alpine

ENV SBT_VERSION 1.2.3
ENV SBT_HOME /usr/local/sbt
ENV PATH ${PATH}:${SBT_HOME}/bin

RUN apk update
RUN apk add --no-cache bash
RUN apk add --no-cache --virtual=build-dependencies curl tar && \
    curl -sL "https://piccolo.link/sbt-$SBT_VERSION.tgz" | gunzip | tar -x -C /usr/local && \
    ln -s /usr/local/sbt/bin/sbt /usr/local/bin/sbt && \
    chmod 0755 /usr/local/bin/sbt && \
    apk del build-dependencies

# preinstall sbt
RUN mkdir -p /tmp/sbt-preload && \
    cd /tmp/sbt-preload && \
    touch build.sbt && \
    mkdir -p project && \
    echo "sbt.version=$SBT_VERSION" > project/build.properties && \
    sbt exit

WORKDIR /app
