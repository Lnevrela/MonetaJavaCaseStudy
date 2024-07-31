# Starting MonetaJavaCaseStudyTestProject:
First thing to do is to build project, this can be done with command:
```
docker compose build
```
MonetaJavaCaseStudyTestProject is run inside docker. In this project is already prepared docker-compose file.  
For starting this file run command:
```
docker compose up -d   
```
This command will start up postgres database and this MonetaJavaCaseStudyTestProject application.

MonetaJavaCaseStudyTestProject application have exposed endpoint on URL:
```
http://localhost:8080/
```
this will need to be called as POST, GET or DELETE method based on what functionality will be called
POST create new ticket and return its values and order number
GET return active ticket containing his values
DELETE delete active ticket

Checking on postgres database can be done by using these connections
```
url=jdbc:postgresql://localhost:5432/MonetaDB
username=Lukas
password=Nevrela
```
