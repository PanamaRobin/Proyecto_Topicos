@echo off
call mvn clean package
call docker build -t com.herrera/ClienteCitas .
call docker rm -f ClienteCitas
call docker run -d -p 9080:9080 -p 9443:9443 --name ClienteCitas com.herrera/ClienteCitas