# MessBookBackend

# Entities

Create Database MessBook in MySQL

Please run below SQL Script to create tables for MySQL Database

```
-- Use Database MessBook
Use MessBook;

-- Create Student table
CREATE TABLE Student (
    id VARCHAR(36) PRIMARY KEY,
    user_name VARCHAR(255),
    roll_number VARCHAR(255),
    name VARCHAR(255),
    time_stamp_of_creation TIMESTAMP,
    password VARCHAR(255),
    role VARCHAR(255)
);

-- Create Menu table
CREATE TABLE Menu (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255),
    price INT,
    mess_id VARCHAR(36),
    FOREIGN KEY (mess_id) REFERENCES Mess(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Create Admin table
CREATE TABLE Admin (
    id VARCHAR(36) PRIMARY KEY,
    user_name VARCHAR(255),
    name VARCHAR(255),
    time_stamp_of_creation TIMESTAMP,
    password VARCHAR(255),
    role VARCHAR(255)
);

-- Create Mess table
CREATE TABLE Mess (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255)
);

-- Create Orders table
CREATE TABLE Orders (
    order_id VARCHAR(36) PRIMARY KEY,
    student_id VARCHAR(36),
    order_date TIMESTAMP,
    resolved_date TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES Student(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Create OrderItems table
CREATE TABLE OrderItems (
    id VARCHAR(36) PRIMARY KEY,
    order_id VARCHAR(36),
    name VARCHAR(255),
    price INT,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE ON UPDATE CASCADE
);

```
