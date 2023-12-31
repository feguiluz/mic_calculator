# mic_calculator
Service that provides the result of arithmetic operations.

## Summary
The objective of this microservice is to provide a solution to the arithmetic operations that it receives.

It is still in the POC phase, so only the addition and subtraction operations are implemented. It is designed with the aim of expanding the scope of operations.

It is a microservice built using Spring Boot and Maven. It provides a rest interface through which we can send arithmetic operations to it.

### Dependencies used
- Spring Boot
- JUnit
- Mockito
- Hamcrest
- Lombok
- TracerAPI (provided)


## Structure of the multi-module project
A hexagonal architecture has been used in this project, which provides separation between layers, reduces complexity, facilitates scalability, and provides a readable and clean design.

<img src="https://imgur.com/H0rIi8S.png"/>

| Module                                                                                                          | Clean Architecture Layer | Comments                                                                                   |
|---------------------------------------------------------------------------------------------------------------------|------------------------------|------------------------------------------------------------------------------------------------|
| ![#52dd4e](https://via.placeholder.com/15/52dd4e/52dd4e.png) *calculator-boot*                       | Infra Layer                  | Main project. Configuration and transversal services.                                          |
| ![#52dd4e](https://via.placeholder.com/15/52dd4e/52dd4e.png) *calculator-api-rest*                   | Infra Layer                  | Primary Adapter. Technology REST.                                                              |
| ![#7DE77B](https://via.placeholder.com/15/52dd4e/52dd4e.png) *calculator-infrastructure*             | Infra Layer                  | (NOT_IMPLEMENTED) Secondary Adapters: Repositories, Services to communicate with another API, etc.               |
| ![#7DE77B](https://via.placeholder.com/15/7DE77B/7DE77B.png) *calculator-application*                | Application Layer            | Use cases.                                                                                     |
| ![#fffd54](https://via.placeholder.com/15/fffd54/fffd54.png) *calculator-domain*                     | Domain Layer                 | Enterprise Bussiness Logic. Core domain and logic. Logic that can be shared between use cases. |

## Getting started
### Prerequisites
The prerequisites to be able to run this microservice locally are:
- Have a version of Java OpenJDK 17 or higher installed.
- Have an installed version of Maven (3.9.4 recommended).
- Have a git client installed.

### Installing
The first step is clone this repository from GitHub:
```
https://github.com/feguiluzgomez/mic_calculator.git
```
To generate code from the definitions of api contracts you must execute (in ```/mic_calculator``` folder):
```
mvn clean install
```

### Running the app in local environment
To start the application in a local environment you must execute (in ```/mic_calculator``` folder):
```
mvn spring-boot:run
```

### Sample GET requests
**Addition operation:**
```
http://localhost:8080/calculator/v1/calculate?operationType=addition&operands=-4.54473,6.544443
```
*Replacing the value of operationType (```addition```) by ```add```, ```sum```, ```plus``` is allowed.*

**Subtraction operation:**
```
http://localhost:8080/calculator/v1/calculate?operationType=subtraction&operands=-4.54473,6.544443
```
*Replacing the value of operationType (```subtraction```) by ```subtract```, ```subtr```, ```minus``` is allowed.*

## Notes
- The TracerAPI provisioned library contains an error. Its implementation (TracerImpl) does not contain an implements statement, so when creating the Bean in the Spring context, the implementation class (TracerImpl) has been used directly.
- Infrastructure module is not implemented because in this POC phase is not necessary. However, this module is part of the hexagonal architecture used and can be used in future versions.