# Person Api

This is a contract-driven project, here we have just the contract definition to enable the front-end and back-end development in parallel.


## Running Stubs(Mock)

Go to your shell in this project directory and execute the command below:

```
    mvn spring-cloud-contract:convert spring-cloud-contract:generateStubs spring-cloud-contract:run
```
    
Now you can check the contract using postman, your browser or any other tool.

In this example just access the URL http://localhost:8080/person/1

## Creating Docker Image

mvn dockerfile:push -Ddockerfile.username=fredericci -Ddocker.user=XXXX -Ddocker.password=XXXXX

 
## Running Tests


Go to your shell in this project directory and execute the command below:

```
    mvn test
```

