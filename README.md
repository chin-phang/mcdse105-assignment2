# Step 1: Setup database
```sql
create database `mcdse105`;
```

# Step 2: Build .war
```shell
# in project root
mvn clean package
```

# Step 3: Run the application
```shell
# in project root
java -jar .\target\assignment2-0.0.1-SNAPSHOT.war
```