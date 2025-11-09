# news-api
# News Platform

## Project Overview
This repository contains two learning projects that work together to build a full-stack news platform and explore AWS deployment workflows:

- **news-api** – A Spring Boot backend service for managing news articles. It uses Spring Data JPA to talk to a MySQL database and is designed to run against a local instance or an Amazon RDS instance.
- **news-client** – A React-based frontend that consumes the backend API to display and manage content.

The main goal is to assemble an end-to-end stack and practice deploying it to AWS services such as EC2 and RDS.

## Technologies & Dependencies
### Backend (`news-api`)
- Java 17 with Spring Boot 3.5
- Spring Web, Spring Data JPA, and Hibernate
- MySQL 8 (local or Amazon RDS)
- Logback for application logging

### Frontend (`news-client`)
- React 18 (bootstrapped with Vite or Create React App)
- Axios for API communication (customizable as needed)

## Prerequisites
- JDK 17 and Maven (the wrapper script `./mvnw` is included)
- Access to a MySQL database
- Node.js 18+ and npm for the frontend

## Running the Backend
1. Clone the repository and switch to the `news-api` directory.
2. Provide the database connection details either through environment variables or by editing `src/main/resources/application.properties`. To use environment variables:
   ```bash
   export SPRING_DATASOURCE_URL="jdbc:mysql://<host>:3306/<db-name>"
   export SPRING_DATASOURCE_USERNAME="<user>"
   export SPRING_DATASOURCE_PASSWORD="<password>"
   ```
3. Start the application locally:
   ```bash
   ./mvnw spring-boot:run
   ```
4. The API becomes available at `http://localhost:8080`, with news endpoints under `/api/news`.

### Build & Test
- Build the executable JAR:
  ```bash
  ./mvnw clean package
  ```
  The artifact is generated at `target/newsapi-0.0.1-SNAPSHOT.jar`.
- Run unit tests:
  ```bash
  ./mvnw test
  ```

## Running the Frontend (`news-client`)
1. Switch to the `news-client` directory.
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm start
   ```
4. The default address is `http://localhost:3000`. CORS is configured in the backend `WebConfig` to allow requests from this origin.

## Key API Endpoints
| Method | Path | Description |
| --- | --- | --- |
| GET | `/api/news` | Retrieve a list of news items |
| GET | `/api/news/{id}` | Retrieve details for a specific news item |
| POST | `/api/news` | Create a new news item |
| PUT | `/api/news/{id}` | Update an existing news item |
| DELETE | `/api/news/{id}` | Delete a news item |

## Deploying to AWS
- **Database** – The default configuration targets an RDS instance declared in `application.properties`. Store credentials securely using environment variables or AWS Secrets Manager.
- **Backend Service** – Use the `deploy.sh` script to update the running application on an EC2 host. The script stops existing processes and relaunches the new JAR with `nohup`.
- **Logs** – `logback-spring.xml` writes logs to both the console and `/home/ec2-user/news-api/app.log` for later inspection.

## Next Steps
- Keep database credentials and other secrets out of version control by relying on environment variables or a secret manager.
- Consider containerizing the services or using AWS Elastic Beanstalk to simplify deployments.
- Expand the test suite with integration tests and service-layer coverage to increase confidence in changes.

Happy building! 🚀
