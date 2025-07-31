FROM ubuntu:noble
WORKDIR /

ARG USERNAME=ubuntu
ARG USER_GID=1001
ARG USER_UID=1001
ARG JVM_VERSION=zulu:17.0.13

ENV JAVA_HOME="/usr/lib/jvm/zulu17-ca-amd64"
ENV JAVA_BIN="$JAVA_HOME/bin"
ENV COURSIER_BIN_DIR="/opt/coursier/bin"
ENV COURSIER_INSTALL_DIR="/home/$USERNAME/.local/share/coursier/bin"
ENV PATH="$PATH:$JAVA_HOME:$JAVA_BIN:$COURSIER_BIN_DIR:$COURSIER_INSTALL_DIR"
ENV JVM_VERSION=$JVM_VERSION
ENV USERNAME=$USERNAME

RUN apt-get update \
    && apt-get install sudo curl gnupg ca-certificates curl -y \
    && echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME \
    && chmod 0440 /etc/sudoers.d/$USERNAME \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/* \
    && curl -s https://repos.azul.com/azul-repo.key | sudo gpg --dearmor -o /usr/share/keyrings/azul.gpg \
    && echo "deb [signed-by=/usr/share/keyrings/azul.gpg] https://repos.azul.com/zulu/deb stable main" | sudo tee /etc/apt/sources.list.d/zulu.list \
    && chmod 644 /etc/apt/sources.list.d/zulu.list \
    && apt-get update \
    && apt-get install zulu17 -y \
    && apt-get clean \
    && mkdir -p $COURSIER_BIN_DIR \
    && curl -fL https://github.com/coursier/coursier/releases/download/v2.1.24/cs-x86_64-pc-linux.gz | gzip -d | sudo tee $COURSIER_BIN_DIR/cs 1>/dev/null \
    && sudo chmod +x $COURSIER_BIN_DIR/cs \
    && cs setup --jvm $JVM_VERSION -y --dir $COURSIER_INSTALL_DIR \
    && cs install scala:{{ cookiecutter.scala_version }} --dir $COURSIER_INSTALL_DIR\
    && rm -rf /root/.cache
USER $USERNAME
