<h1>DP_Zuul API Service</h1>

<h2> Direct API Calls - Access Using Webpage</h2>
<a href="users-service"> users-service </a> <br/>
<a href="ports-service"> ports-service </a> <br/>

<hr/>
<h2> Eureka API Calls - Access Using Postman</h2>
<a href="eusers"> eUsers </a> <br/>
<a href="eports"> eports</a> <br/>

<hr/>





<code>
    users-service:  
    
      url: http://localhost:9051/dpuser/  
      
      
      
    ports-service:  
    
      url: http://localhost:9061/dpports/   
      
      
    eureka-users:  
    
      path: /eusers/**  
      serviceId: DPUSERS-SERVICE    
      
 
    eureka-ports:
    
      path: /eports/**
      serviceId: DPPORTS-SERVICE        

</code>
 