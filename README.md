# Hotel Management System (Java)

## Description
The Hotel Management System is a Java-based application designed to automate the day-to-day operations of a hotel. This system allows hotel staff to manage customer bookings, check-ins, check-outs, and room availability. It offers functionalities such as booking management, room categorization, payment tracking, and generating reports. The system uses **Java AWT** and **Java Swing** for building the graphical user interface (GUI), providing a user-friendly interface for hotel management.

## Features
- **Room Management**: View and update room availability.
- **Customer Management**: Store and retrieve customer details such as name, contact info, and booking history.
- **Booking System**: Make, update, and cancel bookings.
- **Check-In and Check-Out**: Efficient check-in and check-out of customers.
- **Payment Tracking**: Record payments made by customers.
- **Reporting**: Generate reports for rooms and payments.
- **GUI**: A simple and intuitive interface built using Java AWT and Swing.

## Prerequisites
- Java 8 or higher
- MySQL or any relational database (for storing booking and customer data)
- JDBC driver for database connectivity
- Java AWT and Swing libraries (included in the JDK)

## Installation

1. Clone the repository

2. Install dependencies:
- Make sure you have Java 8 or above installed on your machine.
- If using MySQL, ensure the MySQL server is running and the JDBC driver is set up in your project.

3. Set up the database:
- Create a database for the system (e.g., `hotel_management`).
- Create tables for customers, bookings, rooms, payments, etc., using the SQL scripts provided in the `db/` directory.

4. Configure the database connection:
- Open `DatabaseConfig.java` and update the database connection details (username, password, and database URL).

5. Compile and run:
- Navigate to the project directory and compile the project using:
  ```
  javac -d bin src/*.java
  ```
- Run the main application:
  ```
  java -cp bin HotelManagementSystem
  ```

## Usage
- Upon running the application, you will be presented with the main menu, where you can:
- **Manage Rooms**: View, add, or update room details.
- **Manage Customers**: Add new customers and update existing details.
- **Booking System**: Make, cancel, or modify bookings.
- **Check-In/Check-Out**: Process guest check-ins and check-outs.
- **View Reports**: Generate room and payment reports.

The system utilizes **Java AWT** and **Swing** for the graphical interface, making it interactive and user-friendly.

## Contributing
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Create a new pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- MySQL for database management
- **Java AWT** and **Java Swing** for the user interface
- JDBC for connecting Java with the database

---

For any issues, contact me via email or open an issue in the repository.

