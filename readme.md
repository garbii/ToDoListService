## ToDoList Backend Application
This application provide services for Todolist Frondend application
##Run Application
Follow these steps to deploy application
```
1- mvn clean package   => Run unit test then create docker image    / For CI job

2- kubectl apply -f ./deployment/k8s/deployment.yaml  => Deploy project on K8S / For CD Job
```
##Application Docs

To list all endpoints of application use bellow URI
```
{application-host}/swagger-ui.html
```
There are two definitions in the swagger UI. 

The first one called "Public Endpoints" includes enpoints for ToDoList operations.

The second one is "Management" for exposed actuator endpoints.

## Deploying application in 3 ways.

### *1- To run in local environment Intellij*

```
Execute JUNIT and Project main class to run in intellij IDE environment. 
```

### *2- To run in K8S environment execute the following commands on application root directory.*
```
Create image:
> docker build . -t todolist-backend:1.0.0-SNAPSHOT

Deploy on K8S:
> kubectl apply deployment.yaml
```
Then open your browser on *http://localhost:30007/*


### *3- Using CI/CD with Circleci Environment*

Each commit to Githup Repository(https://github.com/garbii/ToDoListService)
will trigger the Circleci CI/CD job. CI/CD job will process the following steps.
```
> 1- Githup send notify to circleci to make new build.

> 2- Circleci checkout the code

> 3- Build

> 4- Test

> 5- Setup environment for image name and tag

> 6- Build and push docker image to DockerHub 

> 7- Deploy image on AWS using Ansible
```
Then open your browser on *http://ec2-15-206-178-60.ap-south-1.compute.amazonaws.com:30007/swagger-ui.html*


