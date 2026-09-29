# DriverCraft - Fleet & Ride Management System

A lightweight, console-based fleet and ride management backend application built using **Java** and **Spring Core**. This project demonstrates clean architecture principles, object-oriented design patterns, and dependency injection without the overhead of a heavy web framework.

## 🚀 Features
* **Admin Operations:** Add new vehicles to the fleet (Economy Cars, Luxury Sedans, XUVs, and Electric Scooters) or remove them by registration number.
* **Customer Bookings:** Hail a taxi by selecting a vehicle type and specifying the duration in hours.
* **Dynamic Fare Calculation:** Automatically computes customized ride fares based on base rates and time variables using polymorphic class methods.
* **In-Memory State Management:** Tracks available versus booked vehicles using structured collection lists.

## 🛠️ Tech Stack
* **Language:** Java
* **Framework:** Spring Core (IoC Container, `@Component`, `@Service`, `@Repository`, `@Controller`)
* **Build Tool:** Maven

## 📂 Architecture
The project follows a strict **Layered Architecture**:
1. **Controller (`systemController`):** Handles user interaction loops and input collection via CLI menus.
2. **Service (`systemService`):** Contains business rules for booking constraints and inventory checks.
3. **Repository (`systemRepository`):** Acts as an intermediary layer between business logic and data storage.
4. **Database/Core:** Manages entity definitions and state lists.
