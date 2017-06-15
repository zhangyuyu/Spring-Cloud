#!/usr/bin/env bash

blue=`tput setaf 6`

#export CONSUL_HOST=`ifconfig  | grep inet | awk '{print $2}' | cut -d "/" -f 1 | tail -n 1`
export CONSUL_HOST=`ipconfig getifaddr en0`
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
  chmod 777 ./build/libs/*.jar
popd

pushd ./name-service
  ./gradlew clean build
  chmod 777 ./build/libs/*.jar
popd

docker-compose up
