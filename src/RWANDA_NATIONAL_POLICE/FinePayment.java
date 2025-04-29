package RWANDA_NATIONAL_POLICE;

// FinePayment class
public class FinePayment extends TrafficRecord {
    public FinePayment(String driverId, String driverName, String vehiclePlate, String violationType, double fineAmount) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType;
        this.fineAmount = fineAmount;
        this.paymentStatus = "UNPAID"; // Initial status
    }

    @Override
    public void processPayment() {
        if ("UNPAID".equals(paymentStatus)) {
            paymentStatus = "PAID";
            System.out.println("Receipt:");
            System.out.println("Driver Name: " + driverName);
            System.out.println("Vehicle Plate: " + vehiclePlate);
            System.out.println("Paid Amount: " + fineAmount + " RWF");
            System.out.println("Payment Status: " + paymentStatus);
        } else {
            System.out.println("Error: Payment already processed. Fine is marked as PAID.");
        }
    }

    @Override
    public void recordViolation() {
        // Not applicable for FinePayment
    }

    @Override
    public void assessFine() {
        // Not applicable for FinePayment
    }
}