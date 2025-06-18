# Patient Management System

A Java console-based application for managing patients, doctors, and appointments in a clinic setting.

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
CREATE DATABASE patient_management;
```

3. Update database configuration:
Edit `src/com/interview/patientmanagementsystem/config/DatabaseConfig.java` and update the following:
- URL: Your MySQL database URL
- USER: Your MySQL username
- PASSWORD: Your MySQL password

4. Build the project:
```bash
mvn clean package
```

5. Run the application:
```bash
java -jar target/patient-management-system-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Default Admin Credentials

- Username: admin
- Password: admin123

## Database Schema

The application uses the following tables:
- users: Stores admin and receptionist accounts
- patients: Stores patient information
- doctors: Stores doctor information
- appointments: Stores appointment details

## Project Structure

- `config`: Database configuration and schema
- `dao`: Data Access Objects for database operations
- `service`: Business logic layer
- `data/dto`: Data Transfer Objects
- `features`: View and controller classes
- `utils`: Utility classes

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request 