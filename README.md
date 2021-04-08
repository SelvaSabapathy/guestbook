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

## Instructions to run in Heroku
* On Heroku
    * Create a new app in Heroku
    * Add Postgres DB resource for that app
    * Add environment variable `SPRING_PROFILES_ACTIVE = heroku`
* In local terminal/shell
    * Set remote repo for the app `heroku git:remote -a [appname]`
* On Heroku
    * Choose Container Registry deployment option
* In local terminal/shell
    * Login to Heroku `heroku login`
    * Login to Heroku container registry `heroku container:login`
    * Push the app to Heroku `heroku container:push web`
    * Deploy the app in Heroku `heroku container:release web`

## URL to reach the app
`https://[appname].herokuapp.com/guestbook`
