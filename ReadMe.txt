/****************************************************************PHASE 2*******************************************************************/

Description

This project implementing a centralised publish subscirbe system where subscribers can subsribe to travel details and latest books written by professional photographers.

Project Structure-

This project is implemented in Spring Boot framework in Java. It uses tomcat as a server.The project structure is as follows:

First, .java files which handles database operations and other back-end operations. They can be found under
/src/main/java
	--->com.sc 	 	Has Main class which is important to run the project.
	--->com.controller 	Handles all the user requests and calls methods to display results to run the project.
	--->com.entity 		for creating and mapping of tables wih Database.
	--->com.dto 		a simple POJO class to store objects.
	--->com.repo		for quering to Database.
	--->com.service		Contains Business Logic.
/target which contains the war file
Second, jsp pages which is displayed to the user.
/src/main/webApp/WEB-INF/jsp

Third, Dockerfile which is used to build docker image.

Fourth, docker-compose.yml, which is used to run the application and database instance on docker container.

Also there is an xml file called pom.xml, which is used to install all the dependencies(jar) files to the project.

How to run this application-

1. Go to the directory where docker-compose.yml file is present.

2. Open command-prompt/terminal, and write command-
	docker build -t dockerimage2 .
	docker-compose up

This will first make database instance and start the application on port 8082.
The endpoint for executing the application is -

	http://localhost:8082/phase2

3. By hitting this, the user will be able to see the UI.
