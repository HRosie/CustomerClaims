package Code.Functions;

import Code.Claims.*;
import Code.Customer.*;
import java.util.Scanner;
import java.util.Set;

public class ClaimMenu {
    private ClaimController claimController;
    private Scanner scanner;

    public ClaimMenu() {
        this.claimController = new ClaimController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("---- Customer Claim Management System ----");
            System.out.println("1. Add Claim");
            System.out.println("2. Update Claim");
            System.out.println("3. Delete Claim");
            System.out.println("4. View Claim");
            System.out.println("5. View All Claims");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addClaim();
                    break;
                case 2:
                    updateClaim();
                    break;
                case 3:
                    deleteClaim();
                    break;
                case 4:
                    viewClaim();
                    break;
                case 5:
                    viewAllClaims();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }

    private void addClaim() {
        System.out.println("Enter claim details:");
        System.out.print("Claim ID: ");
        String id = scanner.nextLine();
        System.out.print("Customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = customerController.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer with ID " + customerId + " does not exist. Cannot add claim.");
            return;
        }.

        // Create a new Claim object with the provided details
        Claims newClaim = new Claims(id, ...); // Complete with other details
        claimController.addClaim(newClaim);
        System.out.println("Claim added successfully!");
    }

    private void updateClaim() {
        System.out.print("Enter claim ID to update: ");
        String id = scanner.nextLine();
        // Implement logic to fetch the claim from storage by its ID
        Claims claimToUpdate = claimController.getClaimById(id);
        if (claimToUpdate != null) {
            // Prompt user to enter updated details for the claim
            System.out.println("Enter updated claim details:");
            // Update claim details here...

            // Call the updateClaim method of the controller to update the claim
            claimController.updateClaim(claimToUpdate);
            System.out.println("Claim updated successfully!");
        } else {
            System.out.println("Claim with ID " + id + " not found.");
        }
    }

    private void deleteClaim() {
        System.out.print("Enter claim ID to delete: ");
        String id = scanner.nextLine();
        // Implement logic to fetch the claim from storage by its ID
        Claims claimToDelete = claimController.getClaimById(id);
        if (claimToDelete != null) {
            // Call the deleteClaim method of the controller to delete the claim
            claimController.deleteClaim(id);
            System.out.println("Claim deleted successfully!");
        } else {
            System.out.println("Claim with ID " + id + " not found.");
        }
    }

    private void viewClaim() {
        System.out.print("Enter claim ID to view: ");
        String id = scanner.nextLine();
        // Implement logic to fetch the claim from storage by its ID
        Claims claim = claimController.getClaimById(id);
        if (claim != null) {
            // Call the displayClaim method of the view to display the claim
            ClaimView.displayClaim(claim);
        } else {
            System.out.println("Claim with ID " + id + " not found.");
        }
    }

    private void viewAllClaims() {
        Set<Claims> allClaims = claimController.getAllClaims();
        for (Claims claim : allClaims) {
            // Call the displayClaim method of the view to display each claim
            ClaimView.displayClaim(claim);
        }
    }

    public static void main(String[] args) {
        ClaimMenu claimMenu = new ClaimMenu();
        claimMenu.displayMenu();
    }
}