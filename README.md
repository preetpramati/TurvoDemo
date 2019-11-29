# TurvoDemo
Prerequsites :

Platform : Java8

Framework : SpringBoot

Build tool : Maven


# Build/Run Process

Clone repository from Github using link: https://github.com/preetpramati/TurvoDemo.git

Open terminal/command prompt at base location and move to each project respectively and hit "mvn clean build"

Once build process is complete hit mvn spring-boot:run at base folder of services to run the services.

Ports can be changed at application.properties of all the services.




## Architecture Diagram :  

![Microservice Architecture](https://github.com/preetpramati/TurvoDemo/blob/master/Architecture.pdf)


## APIs Exposed :

POST : http://oauth-service:8084/login - Retrieves oauth token for the user

GET : http://oauth-service:8084/getDetails/{id} - Get member details if he is registered for flash sale or not

POST : http://oauth-service:8084//validate - Vaidate if user has correct access token or not

GET : http://inventory-management-service:8082/getProducts/{memberid} - Get product list if member is registered

PUT : http://ordering-service:8085/order - Allows a registered user to place order, internally used by API-Gateway

POST : http://api-gateway-service:8081/order - Entry point for user into the systme to make order


## DB Scripts :

Oauth DB:

CREATE TABLE `MemberLogin` (
  `memberid` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `token` varchar(250) DEFAULT NULL,
  `expiry` TIMESTAMP DEFAULT NULL,
  `isRegistered` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`memberid`)
)

Inventory DB:

CREATE TABLE `InventoryList` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `s3URL` varchar(250) DEFAULT NULL,
  `availableCount` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

Shipping DB:

CREATE TABLE `ShippingOrders` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `memberid` int(6) NOT NULL,
  `productid` int(6)  NOT NULL,
  `status`   tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
)




