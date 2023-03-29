import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Flight> flights = new ArrayList<>();
    
    static class Flight {
        String name;
        String number;
        String status;
        
        Flight(String name, String number, String status) {
            this.name = name;
            this.number = number;
            this.status = status;
        }
    }
    
    static void addFlight() {
        Scanner scanner = new Scanner(System.in);
        boolean addMore = true;
        while (addMore) {
            System.out.println("Enter the flights details:");
            System.out.println("Enter the flight name:");
            String name = scanner.nextLine();
            System.out.println("Enter the flight number:");
            String number = scanner.nextLine();
            System.out.println("Enter the status:");
            String status = scanner.nextLine();
            flights.add(new Flight(name, number, status));
            System.out.println("Do you want to add more flight (Yes/No):");
            addMore = scanner.nextLine().equalsIgnoreCase("yes");
        }
    }
    
    static void changeStatus() {
        Scanner scanner = new Scanner(System.in);
        boolean changeMore = true;
        while (changeMore) {
            System.out.println("Enter the flight number:");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (index >= 1 && index <= flights.size()) {
                System.out.println("Enter the new status:");
                String status = scanner.nextLine();
                flights.get(index - 1).status = status;
                System.out.println("Do you want to change status (Yes/No):");
                changeMore = scanner.nextLine().equalsIgnoreCase("yes");
            } else {
                System.out.println("Invalid flight number, please try again.");
            }
        }
    }
    
    static void displayFlights() {
        System.out.println("Flight Status");
        for (int i = 0; i < flights.size(); i++) {
            System.out.println((i+1) + " " + flights.get(i).status);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Schedule Flight");
            System.out.println("2. Change Status");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.println("Enter your options:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    changeStatus();
                    break;
                case 3:
                    displayFlights();
                    break;
                case 4:
                    System.out.println("You are logged-out");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
