FROM alpine
WORKDIR /root/hello-world
COPY Helloworld.java /root/hello-world

#Install JDK
RUN apk add openjdk8
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:$JAVA_HOME/bin

#compile and run
RUN javac Helloworld.java

ENTRYPOINT java Helloworld