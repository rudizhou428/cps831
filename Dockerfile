FROM alpine
WORKDIR /root/gameworld
COPY GameWorld.java /root/gameworld
COPY Hangman.java /root/gameworld
COPY Game.java  /root/gameworld

#Install JDK
RUN apk add openjdk8
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:$JAVA_HOME/bin

#compile and run
RUN javac Game.java GameWorld.java Hangman.java

ENTRYPOINT java GameWorld