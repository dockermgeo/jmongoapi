
PROJECT=mongojrest
VERSION=0.0.1

install: java.buildclean docker.build

build: java.build docker.build

jb: java.build java.run
java.run:
	java -jar target/$(PROJECT)-$(VERSION).jar

java.build:
	mvn install

java.buildclean:
	mvn clean install

docker.build:
	docker build -f Dockerfile -t dockermgeo/$(PROJECT) .

docker.run.db:
	nohup docker-compose -f docker-mongo.yml up &
