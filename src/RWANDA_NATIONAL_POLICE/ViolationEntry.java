package RWANDA_NATIONAL_POLICE;

import java.util.Scanner;

// ViolationEntry class
public class ViolationEntry extends TrafficRecord {
    private static final String[] ALLOWED_VIOLATIONS = {"SPEEDING", "RED_LIGHT", "NO_HELMET", "DUI"};

    public ViolationEntry(String driverId, String driverName, String vehiclePlate, String violationType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType;
        this.paymentStatus = "UNPAID"; // Initial status
    }

    @Override
    public void recordViolation() {
        // Validate violation type
        for (String allowed : ALLOWED_VIOLATIONS) {
            if (allowed.equalsIgnoreCase(violationType)) {
                System.out.println("Violation recorded: " + violationType + " for driver " + driverName);
                return;
            }
        }
        System.out.println("Error: Invalid violation type.");
    }

    @Override
    public void assessFine() {
        // Not applicable for ViolationEntry
    }

    @Override
    public void processPayment() {
        // Not applicable for ViolationEntry
    }
}