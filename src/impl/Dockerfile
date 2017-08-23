FROM ubuntu:latest

MAINTAINER Ram Pathangi "rpathangi@gmail.com"

EXPOSE 8000 8080

ENV BASEDIR /app

RUN mkdir $BASEDIR

WORKDIR $BASEDIR

RUN apt-get update && apt-get install -y wget git vim curl python python-pip python-setuptools software-properties-common openjdk-8-jdk openjdk-8-jre libjansi-java

RUN pip install --upgrade pip

RUN pip install predictionio

RUN wget http://apache.mirrors.tds.net/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz

RUN tar xzvf apache-maven-3.5.0-bin.tar.gz

ENV PATH $PATH:$BASEDIR/apache-maven-3.5.0/bin

ENV PIO_ROOT /app/pio

RUN mkdir $PIO_ROOT

RUN mkdir $PIO_ROOT/vendors

WORKDIR $PIO_ROOT/vendors

RUN wget https://downloads.lightbend.com/scala/2.10.6/scala-2.10.6.deb

RUN apt-get install -y libjansi-java

RUN dpkg -i scala-2.10.6.deb

RUN wget http://d3kbcqa49mib13.cloudfront.net/spark-1.6.3-bin-hadoop2.6.tgz

RUN tar zxvfC spark-1.6.3-bin-hadoop2.6.tgz $PIO_ROOT/vendors

RUN wget https://download.elastic.co/elasticsearch/elasticsearch/elasticsearch-1.7.6.tar.gz

RUN tar zxvfC elasticsearch-1.7.6.tar.gz $PIO_ROOT/vendors

RUN wget http://archive.apache.org/dist/hbase/1.2.5/hbase-1.2.5-bin.tar.gz

RUN tar zxvfC hbase-1.2.5-bin.tar.gz $PIO_ROOT/vendors

WORKDIR $PIO_ROOT

RUN wget http://apache.claz.org/incubator/predictionio/0.11.0-incubating/apache-predictionio-0.11.0-incubating.tar.gz

RUN tar zxvf apache-predictionio-0.11.0-incubating.tar.gz

RUN sh make-distribution.sh

#COPY hbase-site.xml $PIO_ROOT/vendors/hbase-1.2.5/conf/hbase-site.xml

#COPY pio-env.sh $PIO_ROOT/conf/pio-env.sh
