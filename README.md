## About Project

- Simple CRUD operations using spring boot. This applications maintains recent 3 accessed objects in cache.
- Databse : Mysql
- Junit is configured along with mockito.


## Database

- Create database named "sales", username "root" and password "admin".
- Apply sql file named "product.sql" present in project to the "sales" database.


## Entities and Utilities
ProductService class provides services for db operations like fetch product list, insert update and delete product. It uses DataCacheUtil utility.
DataCacheUtil is a utility class which works as cache manager. This utility has cache memory with size 3. When any operation from insert, update delete takes place,
utility update the cache memory accordingly. It removes least recent record from cache if size exceeded.


## running the project

- Run the project using "Run as spring boot app" and use url "http://localhost:8080/" in browser. This will list out all records present in database.
- You can add, update or delete record from this screen.
- Url "http://localhost:8080/recent" will show recent 3 accessed objects in descending order of date (latest first). Clear product link will help to flush the cache memory.