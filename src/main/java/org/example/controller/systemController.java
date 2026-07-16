package org.example.controller;

import org.example.core.*;
import org.example.service.systemService;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class systemController {
    private final systemService ss;
    public systemController(systemService ss){
        this.ss = ss;
    }
    public void startApplicationLoop(){
        Scanner scanner = new Scanner(System.in);
        boolean system = false;
        System.out.println("****************************");
        System.out.println("########DRIVERCRAFT#########");
        System.out.println("Fleet&Ride Management System");
        System.out.println("****************************");
        System.out.print("Do you want to log in? (y/n):");
        char ch = scanner.next().toUpperCase().charAt(0);
        scanner.nextLine();
        if(ch == 'Y'){
            system = true;
        }
        while(system){
            boolean admin = false, customer = false;
            System.out.print("Who are you?:\n1->Admin\n2->Customer\n3->Log out\n");
            int q = scanner.nextInt();
            scanner.nextLine();
            if(q == 1){
                admin = true;
                while(admin){
                    System.out.print("What do you want to do?:\n1->Add a vehicle\n2->Remove a vehicle?\n3->Exit\n");
                    int c = scanner.nextInt();
                    scanner.nextLine();
                    switch(c){
                        case 1->{
                            while(true){
                                System.out.println("What is the type of vehicle you want to add?\n1->Economycar\n2->Luxurycar\n3->Electric Scooter\n4->XUV");
                                System.out.print("Make your choice: ");
                                int C = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter the registration number of the car: ");
                                int rno = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter the model of the car: ");
                                String m = scanner.nextLine();
                                System.out.print("Enter the name of the driver: ");
                                String d = scanner.nextLine();
                                scanner.nextLine();
                                switch(C){
                                    case 1->{
                                        economycar eco = new economycar(rno, m, d);
                                        ss.Addvehicle(eco);
                                    }
                                    case 2->{
                                        luxurysedan lux = new luxurysedan(rno, m, d);
                                        ss.Addvehicle(lux);
                                    }
                                    case 3->{
                                        electricscooter ele = new electricscooter(rno, m, d);
                                        ss.Addvehicle(ele);
                                    }
                                    case 4->{
                                        xuv aks = new xuv(rno, m, d);
                                        ss.Addvehicle(aks);
                                    }
                                    default-> System.out.println("ERROR!!...Make a Valid choice!...");
                                }
                                System.out.println("Successfully added to the fleet!!...");
                                System.out.print("Do you want to add more cars?? (y/n): ");
                                char xm = scanner.next().toUpperCase().charAt(0);
                                scanner.nextLine();
                                if(xm == 'N'){
                                    break;
                                }
                            }
                        }
                        case 2->{
                            while(true){
                                System.out.print("Enter the type of car you want to remove: ");
                                String remove = scanner.nextLine();
                                Fleetmanager F = Fleetmanager.getInstance();
                                if(remove.equalsIgnoreCase("Economycar")){
                                    if(F.economy() <= 0){
                                        System.out.println("No cars of this type left..");
                                        break;
                                    }
                                }
                                else if(remove.equalsIgnoreCase("luxurysedan")){
                                    if(F.luxury() <= 0){
                                        System.out.println("No cars of this type left..");
                                        break;
                                    }
                                }
                                else{
                                    if(F.Scooter() <= 0){
                                        System.out.println("No cars of this type left..");
                                        break;
                                    }
                                }
                                F.removecarfromfleet(remove);
                                System.out.println("Removal successful...");
                                System.out.print("Do you want to add more cars?? (y/n): ");
                                char ym = scanner.next().toUpperCase().charAt(0);
                                scanner.nextLine();
                                if(ym == 'N'){
                                    break;
                                }
                            }
                        }
                        case 3->{
                            System.out.println("Exiting...");
                            admin = false;
                        }
                    }
                }
            }
            else if(q == 2){
                customer = true;
                while(customer){
                    while(true){
                        System.out.print("Do you want to hail a Taxi? (y/n): ");
                        char zm = scanner.next().toUpperCase().charAt(0);
                        if(zm == 'Y'){
                            System.out.print("What type of Taxi do you want to book?:\n1->Economy car\n2->Luxury Sedan\n3->Electric Scooter\n");
                            int t = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Distance: ");
                            int D = scanner.nextInt();
                            scanner.nextLine();
                            Fleetmanager f = Fleetmanager.getInstance();
                            switch(t){
                                case 1->f.alloccars("EconomyCar", D);
                                case 2->f.alloccars("LuxurySedan", D);
                                case 3->f.alloccars("ElectricScooter", D);
                                default->System.out.println("Select a valid car type...");
                            }
                            break;
                        }
                    }
                    System.out.print("Do you want to hail another taxi? (y/n): ");
                    char choice = scanner.next().toUpperCase().charAt(0);
                    scanner.nextLine();
                    if(choice == 'N'){
                        customer = false;
                    }
                }
            }
            else{
                System.out.println("Logging out....");
                system = false;
            }
        }
    }
}
