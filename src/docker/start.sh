#!/usr/bin/env bash

set -e

tiller -b $PIO_HOME/conf -e $ENVIRONMENT_NAME -v

source /app/pio/conf/pio_config_tiller.sh

pio-start-all

jps -l

pio status

cd /app/ndscheduler

make simple >> /logs/"$(date +"ndscheduler_%Y%m%d%H%M%S").log"