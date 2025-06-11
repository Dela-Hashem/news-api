#!/bin/bash

# Stop any running app
pkill -f 'newsapi' || echo "Nothing to kill"

rm -f /home/ec2-user/news-api/target/*.jar.original

nohup java -jar /home/ec2-user/news-api/newsapi-0.0.1-SNAPSHOT.jar > /home/ec2-user/news-api/app.log 2>&1 < /dev/null &

sleep 3
disown
exit 0
