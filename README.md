# graphql-netflix-dgs-demo

A minimal GraphQL demo project built with [Netflix's DGS Framework](https://github.com/Netflix/dgs-framework) and Spring Boot. 
Even though this is very much a starter project, I gave it a solid foundation for showcasing GraphQL with Netflix’s DGS framework.
This demo project serves as a starting point for exploring schema-first GraphQL API development in Java.

## Purpose

This project was created to experiment with:
- GraphQL schema-first design
- Spring Boot integration with DGS
- Basic query and resolver setup
- Clean code structure for scalable GraphQL services

## Tech Stack

- Java 11+
- Spring Boot
- Netflix DGS Framework
- Gradle

## Project Structure
    src/
    ├── main/
    │   ├── java/
    │   │   └── com.example.dgsdemo/
    │   │       ├── DgsDemoApplication.java
    │   │       └── datafetchers/
    │   │           └── ExampleDataFetcher.java
    │   └── resources/
    │       └── schema/
    │           └── schema.graphqls

## GraphQL Schema

Located in `src/main/resources/schema/schema.graphqls`, the schema defines basic queries such as:

```graphql
type Query {
  hello: String
}
```

## Resolvers
Resolvers are implemented using @DgsComponent and @DgsData annotations. Example:
@DgsComponent
public class ExampleDataFetcher {
    @DgsData(parentType = "Query", field = "hello")
    public String getHello() {
        return "Hello from DGS!";
    }
}

## Running the App
- Clone the repo:
git clone https://github.com/michaelmonson/graphql-netflix-dgs-demo.git
cd graphql-netflix-dgs-demo
- Build and run:
./gradlew bootRun
- Access GraphQL Playground (if configured) or test queries via Postman/cURL.

## Additional Notes
- This is a demo project—feel free to expand it with mutations, subscriptions, or federation.
- Ideal for learning, prototyping, or onboarding new developers to GraphQL with DGS.

