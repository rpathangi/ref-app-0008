#!/usr/bin/env bash

set -e

tiller -b $PIO_HOME/conf -e $ENVIRONMENT_NAME -v

source /app/pio/conf/pio_config_tiller.sh

pio-start-all

jps -l

pio status

cd /app/ndscheduler

nohup make simple >> /logs/"$(date +"ndscheduler_%Y%m%d%H%M%S").log" &

cd $PIO_HOME/MyRecommendation

pio app new MyApp1

export ACCESS_KEY=$(pio app list | awk '{ print $7 }' | sed '2q;d')

curl https://raw.githubusercontent.com/apache/spark/master/data/mllib/sample_movielens_data.txt --create-dirs -o data/sample_movielens_data.txt

python data/import_eventserver.py --access_key $ACCESS_KEY

pio build --verbose

pio train

pio deploy
