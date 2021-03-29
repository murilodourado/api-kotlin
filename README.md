# Kotlin REST API
The following api is used as example, was implemented using Spring and Kotlin:

## Build
```
./gradlew clean build
```
## Running
```
./gradlew bootRun 
```

## MongoDB
at the docker compose folder run the following command
```
docker-compose up -d
```
You should create a new db call "userdb", you call create using cli or [compass](https://docs.mongodb.com/compass/master/install/)
use the credentials at docker-compose.yml

### TODO
- [X] Create example using Kafka
- [] Change docker compose to create automactilly the database
- [] Create Test for Kafka Events    