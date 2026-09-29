package org.example.controller;

import org.example.core.*;
import org.example.service.SystemService;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class SystemController {
    private final SystemService systemService;
    private final Scanner scanner = new Scanner(System.in);

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    public void startApplicationLoop() {
        boolean running = true;
        System.out.println("****************************");
        System.out.println("########DRIVERCRAFT#########");
        System.out.println("Fleet & Ride Management System");
        System.out.println("****************************");

        while (running) {
            System.out.print("\nWho are you?\n1->Admin\n2->Customer\n3->Exit\nChoice: ");
            String input = scanner.nextLine().trim();

            if (input.equals("1")) {
                adminMenu();
            } else if (input.equals("2")) {
                customerMenu();
            } else if (input.equals("3")) {
                System.out.println("Exiting System...");
                running = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private void adminMenu() {
        boolean admin = true;
        while (admin) {
            System.out.print("\nAdmin Menu:\n1->Add a vehicle\n2->Remove a vehicle\n3->View available vehicles\n4->Back\nChoice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addVehicleMenu();
                case "2" -> removeVehicleMenu();
                case "3" -> systemService.displayAvailableVehicles();
                case "4" -> admin = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addVehicleMenu() {
        try {
            System.out.print("Vehicle type:\n1->EconomyCar\n2->LuxurySedan\n3->ElectricScooter\n4->XUV\nChoice: ");
            String typeChoice = scanner.nextLine().trim();

            System.out.print("Enter registration number (integer ID): ");
            int regNo = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter model: ");
            String model = scanner.nextLine().trim();

            System.out.print("Enter driver name: ");
            String driver = scanner.nextLine().trim();

            switch (typeChoice) {
                case "1" -> systemService.addVehicle(new EconomyCar(regNo, model, driver));
                case "2" -> systemService.addVehicle(new LuxurySedan(regNo, model, driver));
                case "3" -> systemService.addVehicle(new ElectricScooter(regNo, model, driver));
                case "4" -> systemService.addVehicle(new Xuv(regNo, model, driver));
                default -> System.out.println("Invalid vehicle type selected.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Registration number must be an integer.");
        }
    }

    private void removeVehicleMenu() {
        try {
            System.out.print("Enter the registration number of the vehicle to remove: ");
            int regNo = Integer.parseInt(scanner.nextLine().trim());
            systemService.removeVehicle(regNo);
        } catch (NumberFormatException e) {
            System.out.println("Error: Registration number must be an integer.");
        }
    }

    private void customerMenu() {
        boolean customer = true;
        while (customer) {
            System.out.print("\nCustomer Menu:\n1->Book a ride\n2->Back\nChoice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                try {
                    System.out.print("Vehicle Type:\n1->EconomyCar\n2->LuxurySedan\n3->ElectricScooter\n4->XUV\nChoice: ");
                    String typeChoice = scanner.nextLine().trim();

                    String type = switch (typeChoice) {
                        case "1" -> "EconomyCar";
                        case "2" -> "LuxurySedan";
                        case "3" -> "ElectricScooter";
                        case "4" -> "XUV";
                        default -> null;
                    };

                    if (type == null) {
                        System.out.println("Invalid type selected.");
                        continue;
                    }

                    System.out.print("For how many hours: ");
                    int hours = Integer.parseInt(scanner.nextLine().trim());
                    systemService.assignAvailableCar(type, hours);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Hours must be an integer.");
                }
            } else if (choice.equals("2")) {
                customer = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}