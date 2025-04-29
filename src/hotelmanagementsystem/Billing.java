package hotelmanagementsystem;
// Billing class
public class Billing extends HotelService {
    public Billing(String guestId, String guestName, String roomType, int stayDays) {
        super(guestId, guestName, roomType, stayDays);
    }

    @Override
    public void generateBill() {
        int costPerNight;
        switch (roomType.toUpperCase()) {
            case "STANDARD":
                costPerNight = 50000;
                break;
            case "DELUXE":
                costPerNight = 80000;
                break;
            case "SUITE":
                costPerNight = 120000;
                break;
            default:
                System.out.println("Error: Invalid room type.");
                return;
        }

        int totalCost = costPerNight * stayDays;
        System.out.println("Bill Summary:");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Guest ID: " + guestId);
        System.out.println("Room Type: " + roomType);
        System.out.println("Days Stayed: " + stayDays);
        System.out.println("Total Cost: " + totalCost + " IDR");
    }

    @Override
    public void bookRoom() {
        // Not applicable for Billing
    }

    @Override
    public void checkoutGuest() {
        // Not applicable for Billing
    }
}