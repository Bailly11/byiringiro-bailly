package RWANDA_NATIONAL_POLICE;

import java.util.Scanner;


public class TrafficFineManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String driverId = "";
        String driverName = "";
        String vehiclePlate = "";
        String violationType = "";

       
        while (true) {
            System.out.print("Enter Driver ID: "); 
            driverId = scanner.nextLine().trim();
            if (driverId.matches("\\d{16}")) { 
                break; 
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

     
        ViolationEntry violationEntry = new ViolationEntry(driverId, driverName, vehiclePlate, violationType);
        violationEntry.recordViolation();

       
        FineAssessment fineAssessment = new FineAssessment(driverId, driverName, vehiclePlate, violationType);
        fineAssessment.assessFine();

       
        FinePayment finePayment = new FinePayment(driverId, driverName, vehiclePlate, violationType, fineAssessment.fineAmount);
        finePayment.processPayment();

        scanner.close();
    }
}
