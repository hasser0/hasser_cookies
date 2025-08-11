FROM debian:bookworm-slim

ARG USERNAME=debian
ARG USER_UID=1000
ARG USER_GID=$USER_UID
ENV JAVA_HOME=/usr/lib/jvm/zulu17
ENV PATH=$PATH:/home/debian/.local/share/coursier/bin
RUN groupadd --gid $USER_GID $USERNAME \
    && useradd --uid $USER_UID --gid $USER_GID -m $USERNAME -s /bin/bash \
    && apt-get update \
    && apt-get install -y sudo curl gnupg ca-certificates \
    && echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME \
    && chmod 0440 /etc/sudoers.d/$USERNAME
USER $USERNAME
WORKDIR /home/debian
RUN curl -sLO https://github.com/coursier/launchers/raw/refs/heads/master/cs-x86_64-pc-linux.gz \
    && gzip -d cs-x86_64-pc-linux.gz \
    && mv cs-x86_64-pc-linux cs \
    && sudo install -o root -g root -m 755 cs /usr/local/bin/ \
    && curl -sL https://github.com/com-lihaoyi/mill/releases/download/0.10.15/0.10.15 > mill \
    && sudo install -o root -g root -m 755 mill /usr/local/bin/ \
    && curl -sL https://repos.azul.com/azul-repo.key | sudo gpg --dearmor -o /usr/share/keyrings/azul.gpg \
    && sudo echo "deb [signed-by=/usr/share/keyrings/azul.gpg] https://repos.azul.com/zulu/deb stable main" | sudo tee /etc/apt/sources.list.d/zulu.list \
    && sudo apt-get update \
    && sudo apt-get install zulu17-jdk -y \
    && sudo apt-get clean \
    && sudo rm -rf /var/lib/apt/lists/*
