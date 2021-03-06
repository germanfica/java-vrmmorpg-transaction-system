# java-vrmmorpg-transaction-system

## Tips

Be careful, DO NOT MOVE classes or packages between modules. It causes an unwanted behaviour and breaks the code!!!! You have to create it from scratch to avoid errors.

## Configurations

Create `service/src/main/resources/database.properties`

```
datasource.driverClassName = com.mysql.cj.jdbc.Driver
datasource.username = your_username
datasource.password = your_password
datasource.url = jdbc:mysql://3.9.222.3:3306/your_db_name
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.hibernate.ddl-auto=none
#spring.jpa.show-sql: true
```

Create `application/src/main/resources/application.properties`

```
# Database
spring.datasource.driverClassName = com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://your_db_ip:3306/your_db_name
spring.datasource.username = your_username
spring.datasource.password = your_password

spring.jpa.database = MYSQL
spring.jpa.show-sql = true

# Spring Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.show_sql=true
spring.jpa.hibernate.ddl-auto=update

# Hibernate
hibernate.dialect: org.hibernate.dialect.MySQL8Dialect
hibernate.show_sql: true
hibernate.hbm2ddl.auto: update
entitymanager.packagesToScan: /

# enable ansi output
spring.output.ansi.enabled = always
```
