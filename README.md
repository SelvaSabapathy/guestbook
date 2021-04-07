Guest Book

## Features
* Any visitor can post their name and a comment to the Guestbook.
* All visitors can see a list of every entry in the Guestbook.

## API Specifications
Endpoint    | Method| Request Body| Response
------------|-------|-------------|----------
/guestbook  |  GET  |             |[{"name":"John Doe", "comment":"Great place and friendly service"}, ...]
/guestbook  |  POST | {"name":"Jane Done", "comment":"Great service"}|


## Instructions to run in Docker
Create custom network

    docker network create --driver bridge guestbook-net

Run postgres instance

    docker run --network guestbook-net -p 5432:5432 --name selva-postgres -e POSTGRES_DB=guestbookdb -e POSTGRES_PASSWORD=OPEN -d postgres

Build Docker Image

    docker build -t guestbook:dev .

Run application in Docker container

    docker run --name guestbook --network guestbook-net -e PORT=8080 -e SPRING_PROFILES_ACTIVE=docker -p 9000:8080 -d guestbook:dev