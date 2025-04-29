package hotelmanagementsystem;

import java.util.Scanner;

// Main class
public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String guestId = "";
        String guestName = "";
        String roomType = "";
        int stayDays = 0;

        // Input validation for Guest ID (must be numeric)
        while (true) {
            System.out.print("Enter Guest ID: "); // Updated prompt
            guestId = scanner.nextLine().trim();
            if (!guestId.isEmpty() && guestId.matches("\\d+")) { // Check if input is not empty and consists only of digits
                break; // Valid input
            } else {
                System.out.println("Error: Guest ID must be numeric and cannot be empty. Please enter a valid Guest ID.");
            }
        }

        // Input for Guest Name
        while (true) {
            System.out.print("Enter Guest Name: ");
            guestName = scanner.nextLine().trim();
            if (!guestName.isEmpty()) {
                break; // Valid input
            } else {
                System.out.println("Error: Guest Name cannot be empty. Please enter a valid Guest Name.");
            }
        }

        // Input for Room Type
        while (true) {
            System.out.print("Enter Room Type (STANDARD, DELUXE, SUITE): ");
            roomType = scanner.nextLine().trim().toUpperCase();
            if (roomType.equals("STANDARD") || roomType.equals("DELUXE") || roomType.equals("SUITE")) {
                break; // Valid input
            } else {
                System.out.println("Error: Invalid room type. Please enter STANDARD, DELUXE, or SUITE.");
            }
        }

        // Input for Stay Duration
        while (true) {
            System.out.print("Enter Stay Duration (in days): ");
            if (scanner.hasNextInt()) {
                stayDays = scanner.nextInt();
                if (stayDays >= 1 && stayDays <= 30) {
                    break; // Valid input
                } else {
                    System.out.println("Error: Stay days must be between 1 and 30.");
                }
            } else {
                System.out.println("Error: Please enter a valid number for stay duration.");
                scanner.next(); // Clear the invalid input
            }
        }

        RoomBooking roomBooking = new RoomBooking(guestId, guestName, roomType, stayDays);
        roomBooking.bookRoom();

        // Simulate guest checkout
        GuestCheckout guestCheckout = new GuestCheckout(guestId, guestName, roomType, stayDays);
        guestCheckout.roomStatus = roomBooking.roomStatus; // Set the room status from RoomBooking
        guestCheckout.checkoutGuest();

        // Generate bill for the stay
        Billing billing = new Billing(guestId, guestName, roomType, stayDays);
        billing.generateBill();

        scanner.close();
    }
}