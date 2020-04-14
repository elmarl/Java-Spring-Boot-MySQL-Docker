# building mysql docker image
docker build -t my-mysql .

# running docker container
docker run -d -p 3306:3306 --name my-mysql -e MYSQL_ROOT_PASSWORD=root my-mysql

# to wrap a java file use
mvn -N io.takari:maven:wrapper  

# building jar for docker image
./mvnw package && -jar target/java-spring-boot-app-0.1.0.jar

# build java project docker image
docker build -t java-spring-boot-app . 