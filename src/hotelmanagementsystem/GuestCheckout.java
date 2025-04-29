package hotelmanagementsystem;

// GuestCheckout class
public class GuestCheckout extends HotelService {
    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays) {
        super(guestId, guestName, roomType, stayDays);
    }

    @Override
    public void checkoutGuest() {
        if (roomStatus.equals("OCCUPIED")) {
            roomStatus = "AVAILABLE";
            System.out.println("Checkout successful for " + guestName + " (ID: " + guestId + ").");
        } else {
            System.out.println("Error: Room is already available.");
        }
    }

    @Override
    public void bookRoom() {
        // Not applicable for GuestCheckout
    }

    @Override
    public void generateBill() {
        // Not applicable for GuestCheckout
    }
}