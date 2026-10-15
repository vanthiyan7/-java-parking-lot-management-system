🚗 Java Parking Lot Management System

A console-based Parking Lot Management System developed using Java to manage vehicle parking, track parking availability, calculate parking duration, and generate parking bills.

This project demonstrates core Java programming concepts, object-oriented programming (OOP), inheritance, collections, date and time handling, and menu-driven application development.

📌 Table of Contents

- "Overview" (#-overview)
- "Features" (#-features)
- "Technologies Used" (#-technologies-used)
- "OOP Concepts Implemented" (#-oop-concepts-implemented)
- "Project Structure" (#-project-structure)
- "Parking Fee Structure" (#-parking-fee-structure)
- "How It Works" (#-how-it-works)
- "Getting Started" (#-getting-started)
- "Sample Output" (#-sample-output)
- "Future Improvements" (#-future-improvements)
- "Author" (#-author)

📖 Overview

The Java Parking Lot Management System is designed to simplify basic parking operations through a command-line interface.

The application supports two types of vehicles: two-wheelers and four-wheelers. Users can park vehicles, check parking availability, release parked vehicles, and calculate parking fees based on the parking duration.

The system automatically records the vehicle's entry time and calculates the parking fee when the vehicle exits.

✨ Features

- 🏍️ Two-Wheeler Parking: Park bikes with a predefined hourly rate.
- 🚘 Four-Wheeler Parking: Park cars with a predefined hourly rate.
- 📝 Vehicle Registration: Register vehicles using their registration numbers.
- 🚫 Duplicate Prevention: Prevent the same vehicle from being parked more than once.
- 📊 Capacity Management: Configure parking capacity separately for bikes and cars.
- 🕒 Time Tracking: Record vehicle entry and exit times.
- 💰 Automatic Fee Calculation: Calculate parking charges based on parking duration.
- ⏱️ Hourly Billing: Round up partial hours and charge for at least one hour.
- 📋 Parking Availability: Display available spaces and the total number of parked vehicles.
- 🧾 Parking Bill: Display vehicle details, parking duration, charged hours, and total fees.
- 🔄 Menu-Driven Interface: Perform multiple parking operations until the user exits the application.

🛠️ Technologies Used

- Language: Java
- Collections: ArrayList
- Date and Time API: LocalDateTime
- Duration Calculation: Duration
- Input Handling: Scanner
- Concepts: Object-Oriented Programming (OOP)

🧠 OOP Concepts Implemented

1. Inheritance

"TwoWheeler" and "FourWheeler" inherit common vehicle properties from the "Vehicle" class.

2. Encapsulation of Responsibilities

The "Vehicle" class stores vehicle information, while the "ParkingLot" class manages parking operations and billing.

Note: The current implementation groups related responsibilities into classes but does not fully enforce encapsulation because its fields are not private.

3. Abstraction

The "ParkingLot" class provides methods such as "parkVehicle()", "releaseParkingSpace()", and "displayParkingAvailability()" to perform parking operations.

4. Constructors

Constructors initialize vehicle details, parking rates, entry times, and parking capacities.

5. Polymorphism

The "parkVehicle()" method accepts a "Vehicle" reference, allowing it to work with both "TwoWheeler" and "FourWheeler" objects.

📂 Project Structure

java-parking-lot-management-system/
│
├── Main.java
├── README.md
└── .gitignore

The current implementation contains multiple classes in a single Java source file, "Main.java".

💵 Parking Fee Structure

Vehicle Type| Hourly Rate
Two-Wheeler (Bike)| ₹20
Four-Wheeler (Car)| ₹50

Billing Rules

- Parking charges are calculated according to the recorded entry and exit times.
- Any partial hour is rounded up to the next hour.
- A minimum charge of one hour applies.
- The parking fee is calculated using:

Parking Fee = Charged Hours × Hourly Rate

For example, if a bike is parked for 90 minutes:

- Hourly rate: ₹20
- Charged hours: 2
- Total parking fee: ₹40

⚙️ How It Works

1. The user enters the parking capacity for two-wheelers and four-wheelers.
2. The application displays a menu of available operations.
3. The user selects an operation.
4. When parking a vehicle, the system checks for duplicate registration numbers and available capacity.
5. The system records the vehicle's entry time when parking succeeds.
6. When a vehicle exits, the system calculates the parking duration and fee.
7. The parking bill is displayed, and the vehicle is removed from the parking list.
8. Users can check parking availability at any time.
9. The application continues until the user selects the exit option.

🚀 Getting Started

Prerequisites

Install Java Development Kit (JDK) 8 or later.

The project uses "LocalDateTime" and "Duration", which are available in Java 8 and later.

Step 1: Clone the Repository

git clone https://github.com/YOUR_USERNAME/java-parking-lot-management-system.git

Replace "YOUR_USERNAME" with your GitHub username.

Step 2: Navigate to the Project Directory

cd java-parking-lot-management-system

Step 3: Compile the Program

javac Main.java

Step 4: Run the Application

java Main

💻 Sample Output

Enter two-wheeler parking capacity:
5
Enter four-wheeler parking capacity:
3

===== PARKING LOT MANAGEMENT =====
1. Park Two Wheeler
2. Park Four Wheeler
3. Exit Vehicle and Pay
4. Display Parking Availability
5. Exit Application
Enter your choice:
1

Enter bike registration number:
TN49AB1234

Bike parked successfully.
Entry Time: 2026-10-15T14:30:00

===== PARKING LOT MANAGEMENT =====
1. Park Two Wheeler
2. Park Four Wheeler
3. Exit Vehicle and Pay
4. Display Parking Availability
5. Exit Application
Enter your choice:

Note: The entry time and registration number shown above are illustrative. Actual output depends on user input and execution time.

🔮 Future Improvements

- [ ] Add proper encapsulation using private fields and getters.
- [ ] Validate registration numbers and user input.
- [ ] Add unit tests for parking and billing operations.
- [ ] Store parking records in a database such as MySQL.
- [ ] Generate unique parking ticket IDs.
- [ ] Add a graphical user interface using Java Swing or JavaFX.
- [ ] Introduce separate classes and packages for better maintainability.
- [ ] Add daily parking reports and revenue summaries.
- [ ] Persist parking records so they survive application restarts.

👨‍💻 Author

Vanthiyath Thevan

- GitHub: https://github.com/vanthiyan7
- LinkedIn: https://www.linkedin.com/in/vanthiyath-thevan-a-44773b29a

---

⭐ If you find this project useful, consider giving the repository a star!
