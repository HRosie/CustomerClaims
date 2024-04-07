package Code.Functions;

import Code.Claims.*;
import Code.Customer.*;
import Code.Files.*;

import java.io.IOException;
import java.util.*;

public class ClaimMenu {
    private ClaimController claimController;
    private CustomerController customerController;
    private Scanner scanner;
    private LoadData loadData;
    private SaveData saveData;
    private String claimsFilePath = "Storage/Claims.txt";
    private String customerFilePath = "Storage/Customer.txt";
    private String insuranceFilePath = "Storage/InsuranceID.txt";
    private String bankInfoFilePath = "Storage/bankInfo.txt";

    public ClaimMenu() {
        this.claimController = new ClaimController();
        this.customerController = new CustomerController();
        this.scanner = new Scanner(System.in);
        this.saveData = new SaveData();
        this.loadData = new LoadData();
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
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();

        Customer customer = customerController.getCustomerById(customerName);
        if (customer == null) {
            System.out.println("Customer with ID " + customerName + " does not exist. Cannot add claim.");
            return;
        }
        InsuranceID insuranceID = findInsuranceIDByCustomerName(customerName);
        if (insuranceID == null) {
            System.out.println("No insurance ID found for customer: " + customerName);
            return;
        }

        // Additional inputs for claim details
        System.out.print("Claim Date (YYYY-MM-DD): ");
        String claimDateStr = scanner.nextLine();
        long claimDateMillis = Date.parse(claimDateStr); // Parse the input date string to milliseconds
        Date claimDate = new Date(claimDateMillis); // Create a Date object from milliseconds

        System.out.print("Exam Date (YYYY-MM-DD): ");
        String examDateStr = scanner.nextLine();
        long examDateMillis = Date.parse(examDateStr); // Parse the input exam date string to milliseconds
        Date examDate = new Date(examDateMillis); // Create a Date object from milliseconds

        System.out.print("Claim Amount: ");
        double claimAmount = Double.parseDouble(scanner.nextLine());

        System.out.print("Status (Leave empty if NEW): ");
        String status = scanner.nextLine();
        Status statusOut = Status.NEW;
        if (!validateStatus(status)) {
            System.out.println("Invalid Status");
            return;
        } else {
            statusOut = Status.valueOf(status);
        }
        System.out.print("Bank Name: ");
        String bankName = scanner.nextLine();
        System.out.print("Account Holder Name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine();
        BankingInfo bankInfo = new BankingInfo(bankName, accountHolderName, accountNumber);

        System.out.print("Number of Documents: ");
        int numDocuments = Integer.parseInt(scanner.nextLine());
        List<String> documents = new ArrayList<>();
        for (int i = 0; i < numDocuments; i++) {
            System.out.print("Enter Document " + (i + 1) + ": ");
            String document = scanner.nextLine();
            documents.add(document);
        }
        // Create a new Claim object with the provided details
        Claims newClaim = new Claims(id, claimDate, examDate, customer, insuranceID , numDocuments, documents, claimAmount, statusOut, bankInfo);
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

    private boolean validateStatus(String statusInput) {
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(statusInput)) {
                return true; // Found a matching status
            }
        }
        return false; // No matching status found
    }

    private InsuranceID findInsuranceIDByCustomerName(String customerName) {
        // Iterate through all customers to find the one with matching name
        for (Customer customer : customerController.getAllCustomers()) {
            if (customer.getCustomerName().equalsIgnoreCase(customerName)) {
                return customer.getInsuranceCardID(); // Return the insurance ID associated with the customer
            }
        }
        return null; // Return null if no matching customer is found
    }

    private void saveClaimsData(Set<Claims> claimsSet, String filePath) {
        List<Claims> claimsList = new ArrayList<>(claimsSet);
        saveData.saveClaimsData(claimsList, filePath);
    }

    private Set<Claims> loadClaimsData(String claimsFilePath, String customerFilePath, String insuranceFilePath, String bankInfoFilePath) {
        List<Claims> claimsList = loadData.loadClaims(claimsFilePath, customerFilePath, insuranceFilePath, bankInfoFilePath);
        return new HashSet<>(claimsList);
    }

    public static void main(String[] args) {
        ClaimMenu claimMenu = new ClaimMenu();
        claimMenu.displayMenu();
    }
}