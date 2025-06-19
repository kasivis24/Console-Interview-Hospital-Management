CREATE DATABASE IF NOT EXISTS careplus;
USE careplus;

-- drop table doctors;
-- drop table receptionists;
-- drop table patients;
-- drop table appointments;

select * from appointments;
select * from doctors;
select * from patients;

-- Doctor Table
CREATE TABLE IF NOT EXISTS doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    specialization VARCHAR(100),
    availability VARCHAR(50)
);

ALTER TABLE doctors
ADD COLUMN availability_type VARCHAR(20),
ADD COLUMN start_time VARCHAR(10),
ADD COLUMN end_time VARCHAR(10);


-- Receptionist Table
CREATE TABLE IF NOT EXISTS receptionists (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

-- Patient Table
CREATE TABLE IF NOT EXISTS patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    phone VARCHAR(15) NOT NULL
);

-- Appointment Table
CREATE TABLE IF NOT EXISTS appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    datetime VARCHAR(50) NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE,
    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE
);
