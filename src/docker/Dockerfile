FROM ubuntu:latest

MAINTAINER Ram Pathangi "rpathangi@gmail.com"

EXPOSE 8000 8080 8888

ENV BASEDIR /app

RUN mkdir $BASEDIR

WORKDIR $BASEDIR

RUN apt-get update && apt-get install -y wget git vim curl python python-pip python-setuptools software-properties-common openjdk-8-jdk openjdk-8-jre libjansi-java ruby virtualenv && gem install tiller

RUN pip install --upgrade pip

RUN pip install predictionio

RUN wget http://apache.mirrors.tds.net/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz

RUN tar xzvf apache-maven-3.5.0-bin.tar.gz

ENV PATH $PATH:$BASEDIR/apache-maven-3.5.0/bin

ENV PIO_HOME /app/pio

RUN mkdir $PIO_HOME

RUN mkdir $PIO_HOME/vendors

WORKDIR $PIO_HOME/vendors

RUN wget https://downloads.lightbend.com/scala/2.10.6/scala-2.10.6.deb

RUN dpkg -i scala-2.10.6.deb

RUN wget http://d3kbcqa49mib13.cloudfront.net/spark-1.6.3-bin-hadoop2.6.tgz

RUN tar zxvfC spark-1.6.3-bin-hadoop2.6.tgz $PIO_HOME/vendors

RUN wget https://download.elastic.co/elasticsearch/elasticsearch/elasticsearch-1.7.6.tar.gz

RUN tar zxvfC elasticsearch-1.7.6.tar.gz $PIO_HOME/vendors

RUN wget http://archive.apache.org/dist/hbase/1.2.5/hbase-1.2.5-bin.tar.gz

RUN tar zxvfC hbase-1.2.5-bin.tar.gz $PIO_HOME/vendors

RUN mkdir $PIO_HOME/deleteme

WORKDIR $PIO_HOME/deleteme

RUN wget http://mirror.cogentco.com/pub/apache/incubator/predictionio/0.11.0-incubating/apache-predictionio-0.11.0-incubating.tar.gz

RUN tar zxvf apache-predictionio-0.11.0-incubating.tar.gz

RUN rm apache-predictionio-0.11.0-incubating.tar.gz

RUN ./make-distribution.sh

RUN tar zxvf PredictionIO-0.11.0-incubating.tar.gz

RUN mv PredictionIO-0.11.0-incubating/* ../.

#Start Batch Setup

RUN mkdir /logs

WORKDIR /app

RUN git clone https://github.com/Nextdoor/ndscheduler.git

#Finish Batch Setup

WORKDIR $PIO_HOME

RUN rm -rf $PIO_HOME/deleteme

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

COPY log4j.properties $PIO_HOME/conf/log4j.properties

COPY hbase-site.xml vendors/hbase-1.2.5/conf/hbase-site.xml

COPY pio-env.sh $PIO_HOME/conf/pio-env.sh

COPY start.sh $PIO_HOME/start.sh

RUN mkdir $PIO_HOME/conf/templates

COPY common.yaml $PIO_HOME/conf/common.yaml

COPY pio-config.erb $PIO_HOME/conf/templates/pio-config.erb

RUN touch $PIO_HOME/conf/pio_config_tiller.sh

RUN chmod 755 $PIO_HOME/conf/pio_config_tiller.sh

RUN chmod 755 $PIO_HOME/start.sh

WORKDIR $PIO_HOME/bin

ENV PATH $PATH:$PIO_HOME/bin

WORKDIR $PIO_HOME

CMD ["bash", "-c", "$PIO_HOME/start.sh"]