#!/bin/bash

pkill -f 'newsapi' || echo "Nothing to kill"

sleep 2

nohup java -jar /home/ec2-user/news-api/target/*.jar > /home/ec2-user/news-api/app.log 2>&1 < /dev/null &

disown
sleep 3
exit 0
