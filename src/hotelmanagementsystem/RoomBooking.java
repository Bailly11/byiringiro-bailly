package hotelmanagementsystem;
public class RoomBooking extends HotelService {
    public RoomBooking(String guestId, String guestName, String roomType, int stayDays) {
        super(guestId, guestName, roomType, stayDays);
    }

    @Override
    public void bookRoom() {
        if (stayDays < 1 || stayDays > 30) {
            System.out.println("Error: Stay days must be between 1 and 30.");
            return;
        }
        if (roomStatus.equals("AVAILABLE")) {
            roomStatus = "OCCUPIED";
            System.out.println("Room booked successfully for " + guestName + " (ID: " + guestId + ").");
        } else {
            System.out.println("Error: Room is already occupied.");
        }
    }

    @Override
    public void checkoutGuest() {
       
    }

    @Override
    public void generateBill() {
        
    }
}
