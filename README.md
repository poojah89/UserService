# User Service
User Service API

Instructions to run the Application:-

This code is developed using Maven, Derby Embedded Database and Spring boot framework. All the APIs are well documented using the latest Swagger specifications.
The codebase for this Project is also updated in the github and can be cloned from the URL : https://github.com/poojah89/UserService.git
Below are the details to run the application,

1. Unzip the zip file "UserService.zip" or clone the code from the above github link and then use an IDE like Eclipse and import this project as Maven->  Existing Maven Projects.
2. In the next window of import, in the field of "root directory" browse the code base where Pom.xml is present, and click finish.
3. After succesfully importing the project to the Eclipse IDE as above, right click on the project and go to option 'Maven', -> 'Update Project'. Click the checkbox for 'Force update of Snapshots/Releases' and then click 'OK'. This will download all the required dependencies for the project as given in the pox.xml file.
4. After the above step and succesful update of Maven dependencies, again right click on the project, -> "Run As" -> "Maven Install". This will show the build is success.
5. Then navigate to the root of the project in eclipse and Right click on this file and do -> "Run As" -> "Spring Boot APP".
6. After few seconds, the eclipse will have a console message stating "Tomcat started on port(s): 8080 (http) with context path". This means the application is started and its ready to test.
7. Now since (SpringDoc)Swagger is implemented for this project to execute the APIs with ease, we can navigate to the below swagger base path of the application,
	http://localhost:8080/swagger-ui.html
	
8. After the swagger URL loads up, please execute the APIs listed under Get,Post,Put,and Delete with the sample data. 
	
9.Alternatively the application can also be tested using a postman without Swagger, but with plain API endpoints as below,
		
		a) Fetch data for an user
			- GET "http://localhost:8080/user/{email}"
		b) Create a new user
			- POST "GET "http://localhost:8080/user"
			Sample request body for this POST API is as below,
					{
						"email": "poojah89@gmail.com",
						"password": "test1",
						"firstName": "pooja",
						"lastName": "hariharan"
					}
		c)Update an user
			-PUT "http://localhost:8080/user/{email}"
			Sample request body for this PUT API is as below,
					{
						"email": "poojah89@gmail.com",
						"password": "test5change",
						"firstName": "pooja",
						"lastName": "hariharan"
					}
		  
		d)Delete a user
			-DELETE "http://localhost:8080/user/{email}"
			we can change the user email path parameter above as per the requirement to delete a user.
			
			
