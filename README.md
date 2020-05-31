# Products Server
basic spring boot app with mysql

## db connection setup:

create database with name ProductsDB (or) replace "ProductsDB" in db_url to your database name

go to file "src/main/resources/application.properties" 

set following database variables:
> db_url=jdbc:mysql://localhost:3306/<enter_database_name>

> db_user=<enter_database_username>

> pass=<enter_database_password>
  


## to run:
build into maven project 

run the jar file formed in the "target" directory 
> ./target/books-0.0.1-SNAPSHOT.jar


