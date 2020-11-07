# sparkjava-lombok-mybatis-example

Code based on https://github.com/mag1309/sparkjava-lombok-mybatis-example

*Libraries Used:*

- Project Lombok (https://projectlombok.org) is a java library that reduce various boilerplate code like constructors, getters, setters, toString, equals, hashCode, etc. 

- Gson is a Java library that can be used to convert Java Objects into their JSON representation.

- MyBatis is a persistence framework which eliminates almost all of the JDBC code and manual setting of parameters and retrieval of results.

*Test of the API can be done via Postmap, Curl, SOAPUI.*

- All persons (GET Request)
  - http://localhost:8080/api/person
  ```{
    "status": "SUCCESS",
    "data": [
      {
        "id": "2",
        "firstName": "Test2",
        "lastName": "Test2",
        "email": "test2@test.com",
        "phone": "2234567890"
      },
      {
        "id": "4",
        "firstName": "ok",
        "lastName": "ok2",
        "email": "ok@ok.com",
        "phone": "9999999999"
      },
    ]
  }```

- Retrive a single records (GET Request)
  - http://localhost:8080/api/person/2
  ```{
    "status": "SUCCESS",
    "data": {
      "id": "2",
      "firstName": "Test2",
      "lastName": "Test2",
      "email": "test2@test.com",
      "phone": "2234567890"
    }
  }```

- Create a records (POST Request)
  - http://localhost:8080/api/person

- Update a records (PUT Request)
  - http://localhost:8080/api/person/1

- Delete a records (DELETE Request)
  - http://localhost:8080/api/person/2

*Compile and run*
- Clone the repository
- Install mvn on machine and check its installation
- Clean up so you can recompile everything	i.e. mvn clean
- Compile	i.e mvn compile
- Create Jar file i.e mvn install
- Run the Jar file to start the server java -jar xyx.jar
