package hotelmanagementsystem;

import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String guestId = "";
        String guestName = "";
        String roomType = "";
        int stayDays = 0;

        while (true) {
            System.out.print("Enter Guest ID: ");
            guestId = scanner.nextLine().trim();
            if (!guestId.isEmpty() && guestId.matches("\\d+")) {
                break; 
            } else {
                System.out.println("Error: Guest ID must be numeric and cannot be empty. Please enter a valid Guest ID.");
            }
        }

        while (true) {
            System.out.print("Enter Guest Name: ");
            guestName = scanner.nextLine().trim();
            if (!guestName.isEmpty()) {
                break; 
            } else {
                System.out.println("Error: Guest Name cannot be empty. Please enter a valid Guest Name.");
            }
        }

        while (true) {
            System.out.print("Enter Room Type (STANDARD, DELUXE, SUITE): ");
            roomType = scanner.nextLine().trim().toUpperCase();
            if (roomType.equals("STANDARD") || roomType.equals("DELUXE") || roomType.equals("SUITE")) {
                break; 
            } else {
                System.out.println("Error: Invalid room type. Please enter STANDARD, DELUXE, or SUITE.");
            }
        }

        while (true) {
            System.out.print("Enter Stay Duration (in days): ");
            if (scanner.hasNextInt()) {
                stayDays = scanner.nextInt();
                if (stayDays >= 1 && stayDays <= 30) {
                    break; 
                } else {
                    System.out.println("Error: Stay days must be between 1 and 30.");
                }
            } else {
                System.out.println("Error: Please enter a valid number for stay duration.");
                scanner.next(); 
            }
        }

        RoomBooking roomBooking = new RoomBooking(guestId, guestName, roomType, stayDays);
        roomBooking.bookRoom();

       
        GuestCheckout guestCheckout = new GuestCheckout(guestId, guestName, roomType, stayDays);
        guestCheckout.roomStatus = roomBooking.roomStatus;
        guestCheckout.checkoutGuest();

        Billing billing = new Billing(guestId, guestName, roomType, stayDays);
        billing.generateBill();

        scanner.close();
    }
}
