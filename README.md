# dataBases Project

## Description

The aim of this project is to demonstrate the usefulness of databases and how they can be integrated with other technologies such as HTML, CSS, Java, JDBC, and MySQL. It showcases the implementation of a database-driven application and provides insights into how different components work together.

## Technologies Used

- HTML
- CSS
- Java
- JDBC
- MySQL



## Project Setup

To run this project locally, follow these steps:

1. Ensure that you have MySQL and JDBC installed on your local machine.
2. Create a MySQL database named `hotel_db`.


There  are  3  Tables  in the data base: 

CREATE TABLE Customers (
  customer_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  email VARCHAR(100),
  phone VARCHAR(20),
  address VARCHAR(200)
);

CREATE TABLE Rooms (
  room_id INT PRIMARY KEY AUTO_INCREMENT,
  room_type VARCHAR(10),
  availability INT,
  price DECIMAL(8, 2)
);

CREATE TABLE Bookings (
  booking_id INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT,
  room_id INT,
  check_in_date DATE,
  check_out_date DATE,
  FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
  FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);




3. Download the project files and place them in the same directory.(You can open a terminal in your local directory and  using 2 commands , both compile and run the program:
   (a) javac HotelDatabase.java

   (b) java -cp ".;C:\Users\odono\Downloads\mysql-connector-j-8.0.33\mysql-connector-j-8.0.33\mysql-connector-j-8.0.33.jar" HotelDatabase
   
   The first commands compiles the code and the second includes the path to your JDBC Driver . (To connect MySQL with java)
   
   Now insertions and other Queries may be run from the Terminal in the Directory, since java is connected directly with the MySQL data base.
   
   Or if an IDE is opened and the java file copied into the IDE, the IDE can be used for the Queries. The java file (in the directory) will be automatically updated if the terminal is again used in the directory.

5. Configure the database connection in the Java code to connect to your local MySQL database.

## GitHub Pages

This project utilizes GitHub Pages, a hosting service provided by GitHub for static websites. You can visit the live site on GitHub Pages to see the appearance of the project :https://csstudent26.github.io/dataBases/ . Note that GitHub Pages only supports static content, so interactivity may be limited in this context.

## Interaction on Your Own Website

On the author's own website, there is an interactive version of this project. By visiting the "Hotel" page, users can interact with the web application and experience its functionality firsthand. Please refer to the author's website for access to the interactive version.

#  Project Status
Please note that this project is currently in progress and not yet fully completed. There are certain functionalities that are still being developed. The following are the pending tasks:

Enable user interaction to allow booking of rooms.
Implement management features to facilitate database interaction.
Create the hotel.html page to enhance user experience and provide additional functionality.
These remaining tasks are critical to the overall completion of the project and will be implemented in future updates. Stay tuned for further developments!

Thank you for your understanding and patience as we work towards enhancing the project's functionality.
