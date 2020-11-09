#!/bin/sh
mvn clean package && docker build -t com.herrera/ClienteCitas .
docker rm -f ClienteCitas || true && docker run -d -p 9080:9080 -p 9443:9443 --name ClienteCitas com.herrera/ClienteCitas