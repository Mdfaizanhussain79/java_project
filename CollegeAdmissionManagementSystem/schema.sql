CREATE DATABASE IF NOT EXISTS college_admission;

USE college_admission;

CREATE TABLE Students (
    StudentID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50),
    DOB DATE,
    Email VARCHAR(50),
    Address VARCHAR(100),
    Marks INT,
    Status VARCHAR(20)
);

CREATE TABLE Courses (
    CourseID INT AUTO_INCREMENT PRIMARY KEY,
    CourseName VARCHAR(50),
    Cutoff INT,
    SeatsAvailable INT
);

CREATE TABLE Applications (
    AppID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID INT,
    CourseID INT,
    Marks INT,
    Status VARCHAR(20),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);
