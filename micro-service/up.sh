#!/usr/bin/env bash

pushd ./user-service
  ./gradlew clean build
  chmod 777 ./build/libs/*.jar
popd

pushd ./name-service
  ./gradlew clean build
  chmod 777 ./build/libs/*.jar
popd

