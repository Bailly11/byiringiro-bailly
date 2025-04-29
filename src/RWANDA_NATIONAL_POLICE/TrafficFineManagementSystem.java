package RWANDA_NATIONAL_POLICE;

import java.util.Scanner;

// Main class
public class TrafficFineManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String driverId = "";
        String driverName = "";
        String vehiclePlate = "";
        String violationType = "";

        // Input for violation entry
        while (true) {
            System.out.print("Enter Driver ID: "); // Updated prompt
            driverId = scanner.nextLine().trim();
            if (driverId.matches("\\d{16}")) { // Check if input is exactly 16 digits
                break; // Valid input
            } else {
                System.out.println("Error: Driver ID must be exactly 16 digits long.");
            }
        }

        System.out.print("Enter Driver Name: ");
        driverName = scanner.nextLine().trim();

        System.out.print("Enter Vehicle Plate (e.g., RAB123D): ");
        vehiclePlate = scanner.nextLine().trim();

        System.out.print("Enter Violation Type (SPEEDING, RED_LIGHT, NO_HELMET, DUI): ");
        violationType = scanner.nextLine().trim();

        // Create ViolationEntry
        ViolationEntry violationEntry = new ViolationEntry(driverId, driverName, vehiclePlate, violationType);
        violationEntry.recordViolation();

        // Create FineAssessment
        FineAssessment fineAssessment = new FineAssessment(driverId, driverName, vehiclePlate, violationType);
        fineAssessment.assessFine();

        // Process payment
        FinePayment finePayment = new FinePayment(driverId, driverName, vehiclePlate, violationType, fineAssessment.fineAmount);
        finePayment.processPayment();

        scanner.close();
    }
}