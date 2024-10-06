Here’s a sample `README.md` for your API that includes both the POST and GET API for managing training centers:

---

# Training Center Management API

This API allows for the management of training centers, including creating new training centers and retrieving a list of existing centers. The API uses Spring Boot and connects to an H2 in-memory database for storage.

## Features

- **Create Training Center (POST)**
- **Get All Training Centers (GET)**

## Technologies Used

- **Spring Boot**
- **H2 Database**
- **Java Validation (JSR-303)** for input validation
- **Spring Boot Validation Exception Handling**

## Prerequisites

- Java 8+
- Maven or Gradle
- Spring Boot
- H2 Database (in-memory)

## Getting Started

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. Build the project with Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application at:
   ```
   http://localhost:8080
   ```

5. You can also access the H2 console at:
   ```
   http://localhost:8080/h2-console
   ```

### API Endpoints

#### 1. Create a Training Center

**POST /api/training-center**

- Creates a new training center with the specified details.
- Validations are applied to ensure that fields are correct.
- JSON input is required.

**Request:**
```json
{
  "centerName": "Tech Institute",
  "centerCode": "ABCD12345678",
  "address": {
    "detailedAddress": "1234 Main St, Building 5",
    "city": "New York",
    "state": "NY",
    "pincode": "10001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot", "Docker"],
  "contactEmail": "info@techinstitute.com",
  "contactPhone": "1234567890"
}
```

**Valid



Here is a detailed `README.md` format for your API, including all necessary information like setup, API usage, validations, and example requests/responses:

---

# Training Center Management API

This is a RESTful API for managing training centers. It allows the creation of new training centers and retrieving a list of existing training centers. The API is built using **Spring Boot** and uses **H2 Database** for data storage.

## Features

- **Create Training Center (POST /api/training-center)**: Allows creating a new training center.
- **Get All Training Centers (GET /api/training-centers)**: Fetches the list of all stored training centers.
- Input validation and error handling are included for various fields.
  
---

## Table of Contents

- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [H2 Database Console](#h2-database-console)
- [API Endpoints](#api-endpoints)
  - [Create Training Center (POST)](#1-create-training-center-post)
  - [Get All Training Centers (GET)](#2-get-all-training-centers-get)
- [Field Validations](#field-validations)
- [Error Handling](#error-handling)
- [Example Requests and Responses](#example-requests-and-responses)
  
---

## Technologies Used

- **Spring Boot**: To build the RESTful APIs.
- **H2 Database**: In-memory database for testing.
- **Java Bean Validation (JSR-303)**: For validating the input fields.
- **Maven**: For building and managing project dependencies.

## Prerequisites

To run this application, you will need the following installed:

- **Java 8 or higher**
- **Maven** (for dependency management and build)

---

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd <project-directory>
   ```

2. **Build the project using Maven**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

---

## Running the Application

After starting the application, the API will be available at `http://localhost:8080`. You can test the API using any API client like Postman or cURL.

### H2 Database Console

You can access the H2 database console in your browser at:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (leave it empty or as per `application.yml`)

---

## API Endpoints

### 1. Create Training Center (POST)

**Endpoint**:  
`POST /api/training-center`

**Description**:  
Creates a new training center.

**Request Body** (JSON):
```json
{
  "centerName": "Tech Institute",
  "centerCode": "ABCD12345678",
  "address": {
    "detailedAddress": "1234 Main St, Building 5",
    "city": "New York",
    "state": "NY",
    "pincode": "10001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot", "Docker"],
  "contactEmail": "info@techinstitute.com",
  "contactPhone": "1234567890"
}
```

**Field Descriptions**:
- `centerName` (String) – **Required**. Must be less than 40 characters.
- `centerCode` (String) – **Required**. Must be exactly 12 characters, alphanumeric.
- `address` (Object) – **Required**.
  - `detailedAddress` (String) – Required.
  - `city` (String) – Required.
  - `state` (String) – Required.
  - `pincode` (String) – Required. Valid Indian PIN code.
- `studentCapacity` (Number) – Optional.
- `coursesOffered` (List<String>) – Optional.
- `contactEmail` (String) – Optional. If provided, must be a valid email.
- `contactPhone` (String) – **Required**. Must be a valid 10-digit phone number.
- `createdOn` (Number) – Auto-generated by the system (epoch time).

**Response**:  
On success, returns the newly created training center in JSON format.

```json
{
  "centerId": 1,
  "centerName": "Tech Institute",
  "centerCode": "ABCD12345678",
  "address": {
    "detailedAddress": "1234 Main St, Building 5",
    "city": "New York",
    "state": "NY",
    "pincode": "10001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot", "Docker"],
  "createdOn": 1696432745000,
  "contactEmail": "info@techinstitute.com",
  "contactPhone": "1234567890"
}
```

### 2. Get All Training Centers (GET)

**Endpoint**:  
`GET /api/training-centers`

**Description**:  
Fetches a list of all stored training centers. If no training centers are found, returns an empty list.

**Response**:
```json
[
  {
    "centerId": 1,
    "centerName": "Tech Institute",
    "centerCode": "ABCD12345678",
    "address": {
      "detailedAddress": "1234 Main St, Building 5",
      "city": "New York",
      "state": "NY",
      "pincode": "10001"
    },
    "studentCapacity": 200,
    "coursesOffered": ["Java", "Spring Boot", "Docker"],
    "createdOn": 1696432745000,
    "contactEmail": "info@techinstitute.com",
    "contactPhone": "1234567890"
  }
]
```

If no training centers exist:
```json
[]
```

---

## Field Validations

- **centerName**: Must be a non-blank string, and less than 40 characters.
- **centerCode**: Must be exactly 12 characters (alphanumeric).
- **address**: All sub-fields (`detailedAddress`, `city`, `state`, `pincode`) are required.
- **pincode**: Must follow valid Indian PIN code format (6 digits).
- **contactEmail**: If provided, must be a valid email format.
- **contactPhone**: Must be exactly 10 digits.

---

## Error Handling

Errors will be returned as JSON responses in case of validation failure. The API uses custom exception handling to return meaningful messages.

Example of an error response:

```json
{
  "centerCode": "Center code must be exactly 12 characters",
  "centerName": "Center name is mandatory",
  "contactPhone": "Phone number must be exactly 10 digits"
}
```

---

## Example Requests and Responses

### Example 1: Successful Training Center Creation

**Request**:
```json
{
  "centerName": "Tech Institute",
  "centerCode": "ABCD12345678",
  "address": {
    "detailedAddress": "1234 Main St, Building 5",
    "city": "New York",
    "state": "NY",
    "pincode": "10001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot", "Docker"],
  "contactEmail": "info@techinstitute.com",
  "contactPhone": "1234567890"
}
```

**Response**:
```json
{
  "centerId": 1,
  "centerName": "Tech Institute",
  "centerCode": "ABCD12345678",
  "address": {
    "detailedAddress": "1234 Main St, Building 5",
    "city": "New York",
    "state": "NY",
    "pincode": "10001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot", "Docker"],
  "createdOn": 1696432745000,
  "contactEmail": "info@techinstitute.com",
  "contactPhone": "1234567890"
}
```

### Example 2: Validation Failure for Invalid Phone Number

**Request**:
```json
{
  "centerName": "Tech Institute",
  "centerCode": "ABCD12345678",
  "address": {
    "detailedAddress": "1234 Main St, Building 5",
    "city": "New York",
    "state": "NY",
    "pincode": "10001"
  },
  "contactPhone": "12345"
}
```

**Response**:
```json
{
  "contactPhone": "Phone number must be exactly 10 digits"
}
```

---

## License

This project is licensed under the MIT License.

---

This `README.md` is detailed enough for developers to understand the functionality of your API, set it up, and interact with it effectively.



Here’s a more detailed format for your `README.md` file, including step-by-step instructions for setting up, running, and testing your Training Center Management API.

---

# Training Center Management API

This API is built with Spring Boot and allows for managing training centers, including creating new centers and retrieving a list of all stored centers. The API includes data validation, proper exception handling, and uses an H2 in-memory database.

## Features

- **Create Training Center (POST API)**
- **Retrieve All Training Centers (GET API)**
- Input validation for fields such as email, phone number, and character limits.
- Custom error messages for validation failures.
- Uses H2 in-memory database for quick setup and testing.

## Technologies Used

- **Java 8+**
- **Spring Boot**
- **H2 Database**
- **JSR-303 Bean Validation** (for input validations)
- **Spring Exception Handling**

## Prerequisites

Before running the application, ensure you have the following installed:

- Java 8 or higher
- Maven or Gradle
- Spring Boot

## Getting Started

### Installation Steps

1. **Clone the repository:**

   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Build the project using Maven:**

   ```bash
   mvn clean install
   ```

3. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

4. **H2 Database Console:**

   Once the application is running, you can access the H2 in-memory database at:
   
   ```
   http://localhost:8080/h2-console
   ```

   **JDBC URL for H2 Console:**
   ```
   jdbc:h2:mem:testdb
   ```

### API Endpoints

#### 1. **Create a New Training Center**

**Endpoint:**  
`POST /api/training-center`

**Description:**  
This API creates and saves a new training center in the database.

**Request Format:**

```json
{
  "centerName": "Tech Institute",
  "centerCode": "ABCD12345678",
  "address": {
    "detailedAddress": "1234 Main St, Building 5",
    "city": "New York",
    "state": "NY",
    "pincode": "10001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot", "Docker"],
  "contactEmail": "info@techinstitute.com",
  "contactPhone": "1234567890"
}
```

**Field Descriptions:**

| Field           | Type       | Description                                              | Validation                      |
|-----------------|------------|----------------------------------------------------------|----------------------------------|
| centerName      | String     | Name of the center (mandatory)                            | Must be less than 40 characters |
| centerCode      | String     | Unique code for the center (mandatory)                    | Must be exactly 12 alphanumeric |
| address         | Object     | Address of the training center (mandatory)                | - DetailedAddress: Text field   |
|                 |            |                                                          | - City: Text field              |
|                 |            |                                                          | - State: Text field             |
|                 |            |                                                          | - Pincode: Numeric (6 digits)   |
| studentCapacity | Number     | Capacity of students (optional)                          | None                            |
| coursesOffered  | List<String> | List of courses offered (optional)                       | None                            |
| createdOn       | Long (Epoch Time) | Automatically generated by the server                 | Cannot be provided by user      |
| contactEmail    | String     | Contact email for the center (optional)                  | Must be a valid email           |
| contactPhone    | String     | Contact phone number for the center (mandatory)          | Must be a valid 10-digit phone  |

**Response Example (Success):**

```json
{
  "id": 1,
  "centerName": "Tech Institute",
  "centerCode": "ABCD12345678",
  "address": {
    "detailedAddress": "1234 Main St, Building 5",
    "city": "New York",
    "state": "NY",
    "pincode": "10001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot", "Docker"],
  "createdOn": 1696438200000,
  "contactEmail": "info@techinstitute.com",
  "contactPhone": "1234567890"
}
```

**Validation Errors (Example):**

If any validation fails, a structured error response will be provided, like:

```json
{
  "centerCode": "Center code must be exactly 12 alphanumeric characters",
  "contactPhone": "Invalid phone number format"
}
```

---

#### 2. **Get All Training Centers**

**Endpoint:**  
`GET /api/training-center`

**Description:**  
Fetches the list of all training centers stored in the database.

**Response Example:**

```json
[
  {
    "id": 1,
    "centerName": "Tech Institute",
    "centerCode": "ABCD12345678",
    "address": {
      "detailedAddress": "1234 Main St, Building 5",
      "city": "New York",
      "state": "NY",
      "pincode": "10001"
    },
    "studentCapacity": 200,
    "coursesOffered": ["Java", "Spring Boot", "Docker"],
    "createdOn": 1696438200000,
    "contactEmail": "info@techinstitute.com",
    "contactPhone": "1234567890"
  }
]
```

If no training centers are found, it will return an empty array:

```json
[]
```

---

## Validation

The following validation rules are enforced:

- **CenterName**: Must be less than 40 characters.
- **CenterCode**: Must be exactly 12 alphanumeric characters.
- **ContactEmail**: If present, must be a valid email.
- **ContactPhone**: Must be a valid 10-digit phone number.
- **CreatedOn**: Automatically generated by the server. Any user input for this field will be ignored.

---

## Exception Handling

Custom exception handling is implemented for validation errors. When a validation error occurs, the API returns a detailed message explaining the failure.

---

## H2 Database Configuration

The application uses an H2 in-memory database for testing purposes. The default database settings are as follows:

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** (empty)

To access the H2 console, visit: `http://localhost:8080/h2-console`

---

## Future Enhancements

- Add pagination to the GET API for fetching training centers.
- Implement search filters based on city, state, or courses offered.
- Add authentication and authorization for enhanced security.

---
