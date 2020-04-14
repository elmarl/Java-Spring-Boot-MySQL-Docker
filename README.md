Docker is needed to run this project. https://www.docker.com/get-started
This docker project uses Docker Compose file version 3.

Ideally, the two folders containing the java app and MySQL image specification should have their own .git folder. However, since this is a simple demo I will keep it as simple as possible.

To run the app. simply use the following command which automatically builds the images and runs the containers, as defined in the docker-compose.yml file:

        docker-compose up

If it has already been built, simply use the following command to rebuild and run:

        docker-compose up --build

//

To generate the images manually. first prepare MySQL image:
building mysql docker image, in </my-mysql> folder use
        
        docker build -t my-mysql .

Second, prepare Java app image. If you haven't already, wrap a java file with maven in </thymeleaf-list-db> folder using
    
        mvn -N io.takari:maven:wrapper  

building jar for docker image, in the same folder as before:
        
        ./mvnw package && -jar target/java-spring-boot-app-0.1.0.jar

build java project docker image, in the same folder as before:

        docker build -t java-spring-boot-app . 
        
Finally, to run the whole project, go to parent folder where the docker-compose.yml file is and run the command:

        docker-compose up
        

For the java application to connect to the MySQL database, it is necessary to set the url in application.properties to the name fo the mysql docker container, don't forget it to localhost as if youre running it without docker on your host pc. Also, I disabled tests in this case in order to build the java app (requires connection to the database). These can be added, but again, I wanted to keep it as simple as possible.
        
 //
 
optional, running mysql docker container alone:

        docker run -d -p 3306:3306 --name my-mysql -e MYSQL_ROOT_PASSWORD=root my-mysql
