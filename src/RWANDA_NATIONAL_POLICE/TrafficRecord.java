package RWANDA_NATIONAL_POLICE;


// Abstract class
public abstract class TrafficRecord {
    protected String driverId;        // National ID or driving license number
    protected String driverName;      // Driver's full name
    protected String vehiclePlate;     // Vehicle registration plate
    protected String violationType;    // Type of violation
    protected double fineAmount;       // Amount of the fine
    protected String paymentStatus;    // Payment status ("UNPAID" or "PAID")

    public abstract void recordViolation();
    public abstract void assessFine();
    public abstract void processPayment();
}