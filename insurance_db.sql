CREATE DATABASE insurance_db;
use insurance_db;
CREATE TABLE Vehicleusers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(15) NOT NULL,
    dateOfBirth DATE NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    zipCode VARCHAR(10) NOT NULL,
    drivingLicenceNumber VARCHAR(20) NOT NULL,
    licenseExpiryDate TIMESTAMP NOT NULL,
    userType ENUM('Driver', 'Passenger', 'Admin') NOT NULL,
    vehicleDetails TEXT NULL
);

INSERT INTO Vehicleusers (firstName, lastName, email, password, phoneNumber, dateOfBirth, city, state, zipCode, drivingLicenceNumber, licenseExpiryDate, userType, vehicleDetails) VALUES
('John', 'Doe', 'john.doe@example.com', 'hashedpassword1', '1234567890', '1985-04-12', 'New York', 'NY', '10001', 'DL123456', '2028-12-31 00:00:00', 'Driver', NULL),
('Jane', 'Smith', 'jane.smith@example.com', 'hashedpassword2', '2345678901', '1992-08-25', 'Los Angeles', 'CA', '90001', 'DL654321', '2027-10-20 00:00:00', 'Driver', NULL),
('Alice', 'Brown', 'alice.brown@example.com', 'hashedpassword3', '3456789012', '1988-06-15', 'Chicago', 'IL', '60601', 'DL789456', '2029-01-15 00:00:00', 'Driver', NULL),
('Bob', 'Johnson', 'bob.johnson@example.com', 'hashedpassword4', '4567890123', '1995-03-10', 'Houston', 'TX', '77001', 'DL147258', '2026-08-05 00:00:00', 'Passenger', NULL),
('Emma', 'Davis', 'emma.davis@example.com', 'hashedpassword5', '5678901234', '1983-11-30', 'San Francisco', 'CA', '94101', 'DL369258', '2028-05-10 00:00:00', 'Driver', NULL),
('Michael', 'Wilson', 'michael.wilson@example.com', 'hashedpassword6', '6789012345', '1990-07-21', 'Dallas', 'TX', '75001', 'DL852963', '2027-09-25 00:00:00', 'Driver', NULL),
('Sophia', 'Martinez', 'sophia.martinez@example.com', 'hashedpassword7', '7890123456', '1993-12-17', 'Miami', 'FL', '33101', 'DL741852', '2029-03-12 00:00:00', 'Passenger', NULL),
('Daniel', 'Anderson', 'daniel.anderson@example.com', 'hashedpassword8', '8901234567', '1987-09-05', 'Phoenix', 'AZ', '85001', 'DL963741', '2030-02-28 00:00:00', 'Driver', NULL),
('Olivia', 'Thomas', 'olivia.thomas@example.com', 'hashedpassword9', '9012345678', '1980-02-14', 'Philadelphia', 'PA', '19101', 'DL357159', '2028-06-30 00:00:00', 'Admin', NULL),
('James', 'White', 'james.white@example.com', 'hashedpassword10', '9123456789', '1998-01-08', 'San Diego', 'CA', '92101', 'DL258369', '2029-04-15 00:00:00', 'Driver', NULL),
('Emily', 'Harris', 'emily.harris@example.com', 'hashedpassword11', '9234567890', '1991-05-23', 'Seattle', 'WA', '98101', 'DL951753', '2027-12-20 00:00:00', 'Driver', NULL),
('William', 'Clark', 'william.clark@example.com', 'hashedpassword12', '9345678901', '1986-10-19', 'Boston', 'MA', '02101', 'DL357951', '2030-07-04 00:00:00', 'Passenger', NULL),
('Ava', 'Lewis', 'ava.lewis@example.com', 'hashedpassword13', '9456789012', '1994-03-29', 'Denver', 'CO', '80201', 'DL159357', '2028-09-11 00:00:00', 'Driver', NULL),
('Ethan', 'Walker', 'ethan.walker@example.com', 'hashedpassword14', '9567890123', '1997-08-04', 'Austin', 'TX', '73301', 'DL852741', '2029-10-18 00:00:00', 'Driver', NULL),
('Isabella', 'Hall', 'isabella.hall@example.com', 'hashedpassword15', '9678901234', '1982-07-12', 'Columbus', 'OH', '43085', 'DL456123', '2027-11-22 00:00:00', 'Passenger', NULL),
('Benjamin', 'Young', 'benjamin.young@example.com', 'hashedpassword16', '9789012345', '1996-02-26', 'Detroit', 'MI', '48201', 'DL753951', '2028-08-09 00:00:00', 'Driver', NULL),
('Mia', 'King', 'mia.king@example.com', 'hashedpassword17', '9890123456', '1989-04-05', 'Nashville', 'TN', '37201', 'DL159852', '2029-01-27 00:00:00', 'Driver', NULL),
('Lucas', 'Scott', 'lucas.scott@example.com', 'hashedpassword18', '9901234567', '1993-11-15', 'Portland', 'OR', '97201', 'DL357486', '2030-06-14 00:00:00', 'Admin', NULL),
('Charlotte', 'Green', 'charlotte.green@example.com', 'hashedpassword19', '9012345678', '1981-12-01', 'Indianapolis', 'IN', '46201', 'DL456987', '2027-05-30 00:00:00', 'Driver', NULL),
('Alexander', 'Baker', 'alexander.baker@example.com', 'hashedpassword20', '9123456789', '1995-09-09', 'Charlotte', 'NC', '28201', 'DL852159', '2028-12-08 00:00:00', 'Driver', NULL);

 USE insurance_db;
 SHOW TABLES;
 DROP TABLE user;
 DROP TABLE Users;
 DESCRIBE Vehicleusers;
 SELECT * FROM Vehicleusers;

CREATE TABLE premium_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plan_name VARCHAR(100) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    start_date DATE NOT NULL,
    expiry_date DATE NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES Vehicleusers(id) ON DELETE CASCADE
);
-- Insert Vehicleusers-
INSERT INTO Vehicleusers (firstName, email) VALUES 
('John Doe', 'john@example.com'),
('Jane Smith', 'jane@example.com'),
('Alice Brown', 'alice@example.com');

-- Insert Premium Details
INSERT INTO premium_details (plan_name, amount, start_date, expiry_date, user_id) VALUES 
('Gold Plan', 49.99, '2024-02-01', '2025-02-01', 1),
('Platinum Plan', 99.99, '2024-01-01', '2025-01-01', 1),
('Silver Plan', 29.99, '2023-12-01', '2024-12-01', 2),
('Diamond Plan', 199.99, '2024-03-01', '2025-03-01', 3);
select * from premium_details;
CREATE TABLE Vehicle (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL,
    model VARCHAR(100) NOT NULL,
    plateNumber VARCHAR(20) UNIQUE NOT NULL,
    vehicleType VARCHAR(50) NOT NULL,
    FOREIGN KEY (userId) REFERENCES Vehicleusers(id) ON DELETE CASCADE
);
INSERT INTO Vehicleusers (firstName, lastName, email, password, phoneNumber, dateOfBirth, city, state, zipCode, drivingLicenceNumber, licenseExpiryDate, userType, vehicleDetails) 
VALUES ('John', 'Doe', 'john@example.com', 'hashedpassword', '1234567890', '1990-05-15', 'New York', 'NY', '10001', 'DL123456', '2028-12-31 00:00:00', 'Driver', NULL);

INSERT INTO Vehicle (userId, model, plateNumber, vehicleType) 
VALUES (1, 'Toyota Corolla', 'ABC1234', 'Sedan');
select * from Vehicle;
CREATE TABLE drivers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    license_number VARCHAR(50) UNIQUE NOT NULL
);
INSERT INTO drivers (name, license_number) VALUES 
('John Doe', 'ABC12345'),
('Jane Smith', 'XYZ67890');

select * from drivers;











