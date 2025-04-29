package RWANDA_NATIONAL_POLICE;

public class FineAssessment extends TrafficRecord {
    public FineAssessment(String driverId, String driverName, String vehiclePlate, String violationType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType;
        this.paymentStatus = "UNPAID"; // Initial status
    }

    @Override
    public void assessFine() {
        switch (violationType.toUpperCase()) {
            case "SPEEDING":
                fineAmount = 50000;
                break;
            case "RED_LIGHT":
                fineAmount = 80000;
                break;
            case "NO_HELMET":
                fineAmount = 30000;
                break;
            case "DUI":
                fineAmount = 150000;
                break;
            default:
                System.out.println("Error: Unrecognized violation type.");
                return;
        }
        System.out.println("Fine assessed: " + fineAmount + " RWF for violation: " + violationType);
    }

    @Override
    public void recordViolation() {
       
    }

    @Override
    public void processPayment() {
        
    }
}
