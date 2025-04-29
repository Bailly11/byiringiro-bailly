package construction;

import java.util.Scanner;

public class RealConstructorSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        String id;
        while (true) {
            System.out.print("Enter Contractor ID: ");
            id = sc.nextLine();
            if (id.matches("\\d+")) {
                break;
            } else {
                System.out.println("Invalid ID. Please enter digits only (e.g., 12345).");
            }
        }

       
        String name;
        while (true) {
            System.out.print("Enter Contractor Name: ");
            name = sc.nextLine();
            if (name.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Invalid name. Please enter only letters and spaces.");
            }
        }

        
        double quantity;
        while (true) {
            System.out.print("Enter Material Quantity (in tons): ");
            if (sc.hasNextDouble()) {
                quantity = sc.nextDouble();
                if (quantity > 0) break;
                else System.out.println("Quantity must be greater than 0.");
            } else {
                System.out.println("Please enter a valid number.");
                sc.next();
            }
        }

        
        double balance;
        while (true) {
            System.out.print("Enter Current Material Balance (in tons): ");
            if (sc.hasNextDouble()) {
                balance = sc.nextDouble();
                if (balance >= 0) break;
                else System.out.println("Balance must not be negative.");
            } else {
                System.out.println("Please enter a valid number.");
                sc.next();
            }
        }

        
        System.out.println("\nChoose Operation:");
        System.out.println("1. Material Delivery");
        System.out.println("2. Material Usage");
        System.out.println("3. Cost Estimation");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                MaterialDelivery delivery = new MaterialDelivery(id, name, quantity, balance);
                delivery.receiveMaterial();
                break;

            case 2:
                MaterialUsage usage = new MaterialUsage(id, name, quantity, balance);
                usage.useMaterial();
                break;

            case 3:
                CostEstimation cost = new CostEstimation(id, name, quantity, balance);
                cost.estimateCost();
                break;

            default:
                System.out.println("Invalid option selected.");
        }

        sc.close();
    }
}
