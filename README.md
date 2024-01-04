# Nimesa Assignment
The Nimesa Assignment application is a Spring Boot project designed to provide a set of REST APIs for managing and discovering EC2 instances, and S3 buckets.



## DataSource Configuration
Configuration is done in application.properties file

server.port=8800
spring.datasource.url=jdbc:mysql://localhost:3306/awsservicesdb?autoReconnect=true&useSSl=false
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

## JPA Configuration
Configuration is done in application.properties file.

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

aws.accessKey=AKIAX5XSI5UTUOMGM5F3
aws.secretKey=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

## SQL CREATE QUERIES

Table=>ec2instance
CREATE TABLE `ec2instance` (`id` bigint NOT NULL, `instance` varchar(255) DEFAULT NULL, `job_id` varchar(255) DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

Table=>s3bucket
CREATE TABLE `s3bucket` (`id` bigint NOT NULL, `bucket` varchar(255) DEFAULT NULL, `job_id` varchar(255) DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

Table=>bucket_file_details
CREATE TABLE `bucket_file_details` (`id` bigint NOT NULL, `bucket_name` varchar(255) DEFAULT NULL, `file` varchar(255) DEFAULT NULL, `job_id` varchar(255) DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


