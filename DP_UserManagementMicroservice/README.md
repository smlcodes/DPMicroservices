# DP_UserManagementMicroservice
-----------------------------------------------

1. Change Port number to : 9051
	```
	application.properties
	### Server port #########
	server.port=9051
	  
	### Context root ########
	server.contextPath=/DPUserManagementService
	```

2. Build Jar & run  
    ```
    java -jar dpuser-1.0.jar
    ```


```java
C:\Git\DPMicroservices\DP_UserManagementMicroservice\target

java -jar -Dserver.port=9052 dpuser-1.0.jar


C:\Git\DPMicroservices\DP_UserManagementMicroservice\target

java -jar -Dserver.port=9053 dpuser-1.0.jar


C:\Git\DPMicroservices\DP_UserManagementMicroservice\target

java -jar -Dserver.port=9054 dpuser-1.0.jar



java -jar -Dserver.port=9051 dpuser-1.0.jar
```




# Ref.
https://www.javaguides.net/2019/12/spring-boot-mongodb-crud-example-tutorial.html

