# Patient Management System

A Java console-based application for managing patients, doctors, and appointments in a clinic setting.


## ER Diagram

- Image ref
- ![image](https://github.com/user-attachments/assets/cb0c916e-c673-4298-8dd4-d5164d4f28c8)


https://dbdiagram.io/d/68539b32f039ec6d36e92bff

## Features

- Admin functionality:
  - Add/remove doctors
  - Manage doctor availability
  - Add/remove receptionists
- Receptionist functionality:
  - Add/manage patient records
  - Book appointments
  - View appointments
  - Search patients

## Prerequisites

- Java 11 or higher
- MySQL 8.0 or higher
- Maven

## Setup Instructions

1. Clone the repository:
```bash
git clone <repository-url>
cd patient-management-system
```

2. Create MySQL database:
```sql
CREATE DATABASE carplus;
```

3. Build the project:
```bash
mvn clean package
```

4. Run the application:
```bash
java -jar target/patient-management-system-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Database Schema

The application uses the following tables:
- receptionist: Store receptionist accounts
- patients: Stores patient information
- doctors: Stores doctor information
- appointments: Stores appointment details

## Project Structure

- `config`: Database configuration and schema
- `model`: Model is for write the business logic
- `data/dto`: Data Transfer Objects
- `features`: View and controller classes
- `utils`: Utility classes

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request 
