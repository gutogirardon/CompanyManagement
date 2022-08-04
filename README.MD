# WIP: A simple Spring Boot MongoDB REST API CRUD with Kotlin.

## Setup
### 1) Deploy MongoDB as a Container

- 1) `docker pull mongo`
- 2) `docker run -d -p 27017-27019:27017-27019 --name mongodb mongo`

To validate, if everything is OK, let’s run the following command:
- `docker ps`

### 2) Dependencies
Gradle
- ```
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
  ```

Maven
- ```
    !-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
	 <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-web</artifactId>
	 </dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>
  ```
