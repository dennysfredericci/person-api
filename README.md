# Person Api

1 - This is a contract-driven project, here we have just the contract definition to enable the front-end and back-end development in parallel.

2 - Included some script to deploy this app on minikube


## Running Stubs(Mock)

Go to your shell in this project directory and execute the command below:

```
    mvn spring-cloud-contract:convert spring-cloud-contract:generateStubs spring-cloud-contract:run
```
    
Now you can check the contract using postman, your browser or any other tool.

In this example just access the URL http://localhost:8080/person/1

## Creating Docker Image

mvn clean package dockerfile:push -Ddocker.user=XXXX -Ddocker.password=XXXXX

 
## Running Tests


Go to your shell in this project directory and execute the command below:

```
    mvn test
```

## Running the image with PostgreSQL

1 - Run a PostgreSQL instance

```
docker run --rm --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres  -e POSTGRES_USER=postgres -e POSTGRES_DB=postgres -d postgres
```

2 - Add the environment variable below to turn On the PostgreSQL profile

SPRING_PROFILES_ACTIVE=postgresql

3 - Add all extra environment variables below to configure the datasource.


DATASOURCE_URL=jdbc:postgresql://localhost:5432/your_database
DATABASE_USER=username
DATABASE_PASSWORD=password

Example:

```
docker run --rm -e SPRING_PROFILES_ACTIVE='postgresql' -e DATASOURCE_URL='jdbc:postgresql://192.168.1.53:5432/postgres' -e DATABASE_USER='postgres' -e DATABASE_PASSWORD='postgres' -p 8080:8080 fredericci/person-api
```