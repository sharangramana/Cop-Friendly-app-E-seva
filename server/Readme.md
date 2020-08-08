# Docker commands

### Create a volume
```
docker create -v /var/lib/mysql --name TYPE-VOLUME-NAME mysql:latest
```
### Create a Container
````
docker run -p 3306:3306 -d -e MYSQL_ROOT_PASSWORD=password --volumes-from TYPE-VOLUME-NAME-TO-RETRIEVE --name=TYPE-CONTAINER-NAME mysql:latest
````
### Build a docker image 
````
docker build . -t Enter-New-Image-Name
````
### Create a container for spring and link with mySQL container
````
docker run -p 9000:8090 --name Enter-new-container-name --link Enter-SQL-container-name :mysql Enter-Image-Name
````
### working series of commands
````
docker create -v /var/lib/mysql --name sql-volume mysql:latest

docker run --name docker-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=copsDB -e MYSQL_USER=user -e MYSQL_PASSWORD=password -d --volumes-from sql-volume mysql:latest --default-authentication-plugin=mysql_native_password

//docker run --name docker-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e MYSQL_USER=user -e MYSQL_PASSWORD=password -d mysql:latest --default-authentication-plugin=mysql_native_password

docker build . -t users-mysql-app

docker run -p 9000:8090 --name final-app --link docker-mysql:mysql users-mysql-app
````