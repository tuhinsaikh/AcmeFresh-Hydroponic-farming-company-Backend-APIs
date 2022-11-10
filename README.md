# AcmeFresh-Hydroponic-farming-company-Backend-APIs
This project required building a website for a hypothetical, state-of-the-art Hydroponic farming company, AcmeFresh. The company obtains revenue from 4 different Sources:

1. Setting up hydroponic farm infrastructure for customers.

2. Selling hydroponic produce obtained from its clients and other firms.

3. Automating farms using modern techniques.

4. Selling produce directly to customers(B2C) from its website.

It has been built using Java, Spring, SpringBoot, MySQL and Hibernate. There are 5 model classes in the project Products, Service, Seller, Customer and Order. The main goal of this project is to create a series of backend APIs so that the user can access the functionalities of the various types of functions from the website.

It is an individual project to complete within 24 hours. I have tried to add as much functionality as possible.

This project is more focused on the order functionality instead of credentials.
As multiple products can order in one order also can be changed the quantity while order products. 

Tech Stacks & Tools Used 
------------------------

Tech Stacks:

1. Java

2. MySQL

3. Spring

4. SpringBoot

5. Hibernate

Tools:

1. Spring Tool Suite

2. Swagger

3. Postman

Classes under the Model package
-------------------------------

1. Product.java

2. ServiceEnum.java

3. Customer.java

4. Seller.java

5. Order.java

Some Endpoints to access the functionalities
--------------------------------------------

Link to Swagger: http://localhost:8888/swagger-ui/index.html#/

To register as a Customer:

http://localhost:8888/customer

To register as a Seller:

http://localhost:8888/seller

To add new products

http://localhost:8888/product

To add products to order:

http://localhost:8888/productsOrder/{customerId}?productsId={productId}&productsQuantity={productsQuantity}

To get all order of a customer:

http://localhost:8888/productsOrder/{customerId}

THANK YOU 
