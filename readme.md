## ToDoList Backend Application
This application provide services for Todolist Frondend application
##Run Application
Follow these steps to deploy application
>1- mvn clean package   => Run unit test then create docker image    / For CI job

>2- kubectl apply -f ./deployment/k8s/deployment.yaml  => Deploy project on K8S / For CD Job

##Application Docs

To list all endpoints of application use bellow URI
> {application-host}/swagger-ui.html

There is two definion in the swagger UI. 

The one called "Public Endpoints" includes enpoints for ToDoList operations.


