# registration-login-app

Example registration/login project dedicated to use the latest Java technologies. Please note that, it is experimental for now, not production ready. I am planning to enchance security features by using Spring Security.

Here is some missing features that needs to be refactored/implemented:
- Complete main features like login mechanism by Spring Security
- Secure endpoints by authentication
- User session
- User role feature
- Activation by email

### Prerequisites
- JDK 8
- Maven

### Building project

To build the project, run the following command on project's root folder:

mvn clean install -DskipTest

This will start building process and create runnable uber war file which makes deployment easier.

registration-login-app includes an embedded H2 database. Whenever program starts, in memory database is created from scratch.

### Starting application

To start the application, locate the installed war file and run the following command:

java -jar registration-login-app-${version}.war

For example:

> java -jar registration-login-app-0.0.1-SNAPSHOT.war

### Test

Check the following URL to ensure the app is running:

http://localhost:18000/app/login

Additionally, there is a client for database in application. 
If you are curious about it, you can check the following URL:

http://localhost:18000/app/h2

### Endpoints

These are endpoints of the application:

 - /login
 - /register
 - /profile

### Usage

To register a new user locate your browser to /register, fill the form, and submit it.
To login, go to /login. Then, you will be redirect to profile page.

### Conclusion

There some challenges in this project. Please do not hesitate to reach me for suggestions :)
