cd ~/Projects/friendspammer-web

docker-compose stop

docker rm friendspammerweb_mongo_1 &
docker rm friendspammerweb_app_1
docker rmi friendspammerweb_app &

mvn clean install

cd ~/Projects/friendspammer-helper
mvn clean install

cd ~/Projects/friendspammer-web
docker-compose up -d
