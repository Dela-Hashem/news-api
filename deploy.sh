#!/bin/bash

pkill -f 'newsapi' || echo "Nothing to kill"
rm -f /home/ec2-user/news-api/target/*.jar.original
rm -f /home/ec2-user/news-api/target/*.jar

nohup java -jar /home/ec2-user/news-api/target/*.jar > app.log 2>&1 < /dev/null &

sleep 3
disown
exit 0
