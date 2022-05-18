```java
C:\Git\DPMicroservices\DP_PortsManagementMicroservice\target

java -jar -Dserver.port=9061 dpports-1.0.jar

java -jar -Dserver.port=9062 dpports-1.0.jar

java -jar -Dserver.port=9063 dpports-1.0.jar

java -jar -Dserver.port=9064 dpports-1.0.jar
```
# DP_UserManagementMicroservice
-----------------------------------------------

1. Change Port number to : 9051
	```
	application.properties
	### Server port #########
	server.port=9051
	  
	### Context root ########
	server.contextPath=/dpportsManagementService
	```

2. Build Jar & run  
    ```
    java -jar dpports-1.0.jar
    ```

C:\Git\DPMicroservices\DP_UserManagementMicroservice\target

java -jar -Dserver.port=9061 dpports-1.0.jar

java -jar -Dserver.port=9062 dpports-1.0.jar

java -jar -Dserver.port=9063 dpports-1.0.jar

java -jar -Dserver.port=9064 dpports-1.0.jar



# Ref.
https://www.javaguides.net/2019/12/spring-boot-mongodb-crud-example-tutorial.html

