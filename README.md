# 52000646_Asignment


<h1 align="center">
  <br>
  <img src="https://user-images.githubusercontent.com/114124106/229993734-aca974ee-a58b-4452-86e9-8cf94bfad6df.png" alt="Markdownify" width="600px">
  <br>
  52000646 - Nguyễn Trọng Đức
  <br>
</h1>

<h4 align="center">Spring Commerce Assignment</h4>
<br>

## Principles and technologies used

* Principles Used:
  - Single Responsibility (Each class should only have one responsibility. Furthermore, it should only have one reason to change).
  - Spring MVC:
    + Consumer Layer or Controller: this is the layer that communicates with the outside and handles requests from outside to the system.
    + Service Layer: Perform operations and handle logic.
    + Repository Layer:: Responsible for communicating with DBs, storage devices, query processing, and returning data types that the Service layer requires.
* Technologies Used:  
  - Java Spring Boot application (Maven project)
  - MySQL (Storage data)
  - Xampp (Connect to DB)
  - I perform the function of uploading product images by encoding them into Base64 so that they can be saved to the DB. The advantage of base64 is to retrieve images quickly by reducing image quality when loading from the server to the client.
  - In this Assignment, I used Spring security to assign permissions for the admin and user. That is, the object logged in as an admin, can access the admin's pages such as adding, deleting, and editing products (product management). Admin will also manage the orders that customers have paid before (order management).
  - If the logged-in object is a customer then they can see the product list. If the customer finds a product that they like, they can view its
details and add it to their shopping cart and proceed to place an order.
  - Thymeleaf (Java template engine for processing and creating HTML, XML, JavaScript, CSS and text).


## Project Structure
* Project overview image
  <h1 align="center">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/229998133-b5297071-531a-4bf0-b935-2f9d9e6a9fdb.png" alt="Markdownify" width="600px">
    <br>
  </h1>
 * Folder Details
    - Folder Model: is the place where all the entity tables are stored and created and stored directly in the Database.
    - Folder Controller: methods are the final destination point that a web request can reach. After being invoked, the controller method starts to process the web request by interacting with the service layer to complete the work that needs to be done.
    - Folder Service: includes methods for performing system functions, interacting directly with the controller.
    - Folder Repository: responsible for communicating with DBs, storage devices, query processing, and returning data types requested by the Service layer.
    - Folder User: include user model and MyUserDetail to store user information which is later encapsulated into Authentication objects
    - Folder WebMvcConfiguration: configure web page redirect when accessing the path is not allowed
    - Folder WebSecurityConfiguration: The WebSecurityConfig class is annotated with @EnableWebSecurity to enable Spring Security’s web security support and provide the Spring MVC integration. Perform the function of decentralization for users and admins.
    - Folder Implement: UserDetailsService is used by DaoAuthenticationProvider for retrieving a username, a password, and other attributes for authenticating with a username and password. Spring Security provides in-memory and JDBC implementations of UserDetailsService. This class implement from UserDetailsService.
    - Besides, the project has Resources Folder, which includes two Folders. That is Static folder include some file css, image, and the Templates Folder include some file HTML about the user interface, error, custom error, and permission page when the user access to the page about the admin.
    

## Spring Security
![image](https://user-images.githubusercontent.com/114124106/230760441-14ac7db5-01bb-4b3e-843b-c0b3da784827.png)

## Admin Permission
- With the absolute security and decentralization of Spring Security. Admin can access all the links of the system.

<h4 align="center">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/230760632-837519a7-15be-4e0a-b5b0-58a143cd96e9.png" alt="image" width="100%">
    <br>
</h4>

![screencapture-localhost-8080-orderManagement-2023-04-09-15_14_35](https://user-images.githubusercontent.com/114124106/230762003-b7f0430e-c2b7-4509-95f5-3d49a1969a99.png)
![screencapture-localhost-8080-orderDetails-4-2023-04-09-15_15_06](https://user-images.githubusercontent.com/114124106/230762018-3e8fa09e-bbf8-47c3-8918-80c354b26dfd.png)

### User Permission
- In contrast to admin, users can only access allowed paths, not allowed to access paths located in ROLE ADMIN
- Here are the links that users are not allowed to access
![image](https://user-images.githubusercontent.com/114124106/230760905-4a195800-d884-461d-a6b6-29f8b071c254.png)
<h4 align="center">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/230760598-1b86a87d-fded-4690-88fb-f7cd4cebd1e4.png" alt="image" width="100%">
    <br>
</h4>


### And below are some pages that both ROLE user and admin can access:
<h4 align="center">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/230761209-9173d690-b9b6-49c9-b2bf-0bf2abb6daea.png" alt="image" width="100%">
    <br>
</h4>
<h4 align="center">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/230761276-bfdf64ef-c957-405c-83ec-9b1f722ff389.png" alt="image" width="100%">
    <br>
</h4>

<h4 align="center">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/230761340-a32adbf7-652e-46f9-836b-57aad8f233c2.png" alt="image" width="100%">
    <br>
</h4>

> **Note**
> And there are some pages that are managed by admin and can only be accessed by admin such as adding, deleting, editing products, managing products as well as managing order details. You can experience the system through the steps below!!

## How To Build Project

To clone and run this application, From your command line:

```bash
# Clone this repository
$ https://github.com/annhducit/52000646_Assignment.git

# Open project by IntelliJ IDE

# Open Xampp and then Apache and MySQL:

# Access to link
$ http://localhost/phpmyadmin/

# Create new database productmanagement

# When we clone the repository from GitHub, we will have a SQL file. What we need to do is insert this file into the database we just created above.

# And click run project.

# Next, open your browser and access the link:
$ http://localhost:8080/

# Spring Security's login interface will appear.
# Below are two accounts that I have made available corresponding to its ROLEs, which are ADMIN and USER:

# ADMIN ACCOUNT:
$ Username: admin
$ Password: anhducadmin

# USER ACCOUNT:
$ Username: anhduc
$ Password: anhduc123

# These passwords will correspond to the encrypted password of the users' table in the database
   
```

> **Note**
> Make sure you have fully implemented the functions listed above to be able to successfully run the project. One point to note is that I converted the image to [Base 64](https://vi.wikipedia.org/wiki/Base64) code so the structure of the SQL file is quite long, but that is not a concern.Good luck !!!

## CRUD Commmad & Postman Snapshots

### Request methods

The request method is the way we distinguish what kind of action our endpoint is being "asked" to perform. Below are the request methods I used in project. Includes method name and concept.

| Method   | Description                                                 |
| -------- | ----------------------------------------------------------- |
| `GET`    | Used to retrieve a single item or a collection of items.    |
| `POST`   | Used when creating new items e.g. a new product, order,netc.|
| `PUT`    | Used to replace a whole item (all fields) with new data.    |
| `DELETE` | Used to delete an item.                                     |


### Full CURL commands
#### Product API

| Method   | URL                                       | Description                              |
| -------- | ----------------------------------------  | ---------------------------------------- |
| `GET`    | `/api/product`                            | Retrieve all products.                   |
| `POST`   | `/api/product/1`                          | Update data product by ID 1.             |
| `POST`   | `/api/product`                            | Create a new product.                    |
| `GET`    | `/api/product/1`                          | Retrieve order by ID 1.                  |             
| `DELETE` | `/api/product/1`                          | Delete produc by ID 1.                   |
| `GET`    | `/api/product?keyword=samsung`            | Search for "samsung" in list product.    |


#### Order API

| Method   | URL                                       | Description                              |
| -------- | ----------------------------------------  | ---------------------------------------- |
| `GET`    | `/api/order`                              | Retrieve all orders.                     |
| `GET`    | `/api/order/1`                            | Retrieve order by ID 1.                  |             
| `DELETE` | `/api/order/1`                            | Delete order by ID 1.                    |


#### User API

| Method   | URL                                       | Description                              |
| -------- | ----------------------------------------  | ---------------------------------------- |
| `GET`    | `/api/user`                               | Retrieve all users.                      |
| `GET`    | `/api/user/1`                             | Retrieve data user by ID 1.              |
| `GET`    | `/api/user/anhduc123`                     | Retrieve data user by username anhduc123.|


#### Category API

| Method   | URL                                       | Description                              |
| -------- | ----------------------------------------  | ---------------------------------------- |
| `GET`    | `/api/category`                           | Retrieve all categories.                 |
| `GET`    | `/api/category/1`                         | Retrieve category  by ID 1.              |             

#### Brand API

| Method   | URL                                       | Description                              |
| -------- | ----------------------------------------  | ---------------------------------------- |
| `GET`    | `/api/brand`                              | Retrieve all brands.                     |
| `GET`    | `/api/brand/1`                            | Retrieve brand by ID 1.                  |             

#### Color API

| Method   | URL                                       | Description                              |
| -------- | ----------------------------------------  | ---------------------------------------- |
| `GET`    | `/api/color`                              | Retrieve all colors.                     |
| `GET`    | `/api/color/1`                            | Retrieve color by ID 1.                  |             


#### Cart API

| Method   | URL                                       | Description                              |
| -------- | ----------------------------------------  | ---------------------------------------- |
| `GET`    | `/api/cart`                               | Retrieve all carts.                      |
| `GET`    | `/api/cart/1`                             | Retrieve cart by ID 1.                   |     


> **Note**
> I just listed the api used in the project. Because the project has security by [Spring security](https://docs.spring.io/spring-security/reference/index.html), when testing the API we have to turn it off and switch back to [RestController](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)

## Postman Snapshots:
### Product API
![image](https://user-images.githubusercontent.com/114124106/230732373-74dbedc7-cff2-4bf6-bab2-05b01c78660a.png)
![image](https://user-images.githubusercontent.com/114124106/230733410-a09d0eb8-d060-49b4-a108-d6bb329ac290.png)


> **Note**
> Do the same for the remaining methods and tables. The APIs are already written in the code, to avoid long lines I didn't insert any images. Thank you so much !!


## Testcase JUnit4 using Mockito
In this project I will create test cases for two Controllers, that is ProductController and OrderController.
<h4 align="center">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/230262107-4d4ad974-fbf9-47f9-9933-64f5603fe183.png" alt="image" width="100%">
    <br>
</h4>

### ProductControllerTest
  - I have success 4 testcase for this Controller. Details in the code:
<h4 align="left">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/230262377-a7f6591f-cbc9-4e46-9495-b0d21cb5105a.png" alt="image" width="300px">
    <br>
</h4>

### OrderControllerTest
  - I have success 3 testcase for this Controller. Details in the code:
<h4 align="left">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/230262899-167f6203-7cdc-4d3b-9da3-5dab99a191aa.png" alt="image" width="300px">
    <br>
</h4>


## Diagram
### Entity-relationship diagram
<h2 align="center">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/230022298-d2a24795-fdbe-451b-816c-42860999206f.png" alt="image" width="100%">
    <br>
  </h2>

### Schema of the database
<h2 align="center">
    <br>
      <img src="https://user-images.githubusercontent.com/114124106/230023052-18dcbcf8-c752-4f47-8f53-946843a75e42.png" alt="image" width="100%">
    <br>
  </h2>
  
## References
  - [How to draw an Entity Relatioship Diagram](https://www.gliffy.com/blog/how-to-draw-an-entity-relationship-diagram)
  - [Spring Security for Spring Boot Integration Tests](https://www.baeldung.com/spring-security-integration-tests)
  - [Spring boot home](https://spring.io/)
  - [Restfull API Tutorials](https://www.tutorialspoint.com/spring_boot/spring_boot_building_restful_web_services.html)
  - Lab lessons taught by Mr. Vo Van Thanh

