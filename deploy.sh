cd ~/Projects/messagesender-web

docker-compose stop

docker rm messagesenderweb_mongo_1 &
docker rm messagesenderweb_app_1
docker rmi messagesenderweb_app &

cd ~/Projects/messagesender-helper
mvn clean install

cd ~/Projects/messagesender-web
mvn clean install
docker-compose up -d
