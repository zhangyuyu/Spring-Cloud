#!/usr/bin/env bash

blue=`tput setaf 6`

if [ "$(uname)" == "Darwin" ]; then
    export CONSUL_HOST=`ipconfig getifaddr en0`
else
    export CONSUL_HOST=`hostname -I | awk '{print $1}'`
fi

echo "${blue}==>Setting environment variable"
echo "Consul host is ${CONSUL_HOST}"

echo "${blue}==>Stopping running container"
docker-compose stop

echo "${blue}==>Removing stopped container"
docker-compose rm -f

echo "${blue}==>Removing exiting network"
docker network rm microservice_wanzi-net

pushd ./user-service
  ./gradlew clean build
  sudo chmod 777 build/
  sudo chmod 777 ./build/libs/*.jar
popd

pushd ./name-service
  ./gradlew clean build
  sudo chmod 777 build/
  sudo chmod 777 ./build/libs/*.jar
popd

docker-compose up
