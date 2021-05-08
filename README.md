# Stock Management System 
System is design with **Microservice** architecture where **Front-End** is design with **NodeJs Framework** and **Back-end** design with **Spring Framework**. All projects are added with one repository with different branches.

### Branch 1. [Front-end](https://github.com/manijangid78/STM-Front-End/tree/front-end)
Client-side view is managed with **NodeJs framework**. View is design with **HTML, CSS and JavaScript**. Through nodejs data is fetched via **RESTApi's** in json format and used that data to view client side.

### Branch 2. [Database-Service](https://github.com/manijangid78/STM-Front-End/tree/database-service)
Database-service is the **RESTApi** that contains end points and according to that end point it provides data in json format. This RESTApi, is design with **SpringBoot Framework** with **Hiberante integrantion**. This RESTApi manages the stock. Using this stock can be added and also can be retrieved.  
### Branch 3. [Sell-Service](https://github.com/manijangid78/STM-Front-End/tree/sell-service)
Sell-service is other **RESTApi**, that manages the sell of the stocks and creates a record of transection of sell. Sell service is also desing with **SpringBoot Framework** with **Hibernate integration**.  

### Branch 4. [Eureka_server](https://github.com/manijangid78/STM-Front-End/tree/eureka-server)
**Eureka server** containes the details of all the microservices. Every service is register with eureka server and then server will hold infromation of the application. Eureka server also known as **Discovery server**. 

## Project Video  
A Demo video is added that helps to understand the whole project.
![video](https://github.com/manijangid78/Stock-Management-System/blob/videoimages/stm.gif)

1. When user add the row material(Stock) then a request goes to database service. This request contains row material details and this details stored in the database and return true.
2. When user add the product then a request goes to database service with product details. That details are stored in the database and return true. 
3. When user search all the row material/product then a request goes for get all row material/product. And database service returns all raw material/product details and using nodejs it will view to the client side.
