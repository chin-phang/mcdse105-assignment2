# Step 1: Run MySQL in Docker
Make sure to install Docker Desktop
```shell
docker run --name mcdse105-mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3306:3306 -d mysql:8
```

# Step 2: Setup database
Use DBBeaver or other client and connect to localhost:3306
```sql
create database `mcdse105`;
```

# Step 3: Build .war
```shell
# in project root
mvn clean package
```

# Step 4: Run the application
```shell
# in project root
java -jar .\target\assignment2-0.0.1-SNAPSHOT.war
```