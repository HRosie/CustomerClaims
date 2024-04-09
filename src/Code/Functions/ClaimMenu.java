package Code.Functions;

import Code.Claims.*;
import Code.Customer.*;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class ClaimMenu
{
    private ClaimControl controller;
    private Scanner sc;

    public ClaimMenu(ClaimControl controller)
    {
        this.controller = controller;
        this.sc = new Scanner(System.in);
    }

    public void displayMenu()
    {
        System.out.println("Enter 1: Add Claim");
        System.out.println("Enter 2: Update Claim");
        System.out.println("Enter 3: Delete Claim");
        System.out.println("Enter 4: Get One Claim");
        System.out.println("Enter 5: Get All Claims");
        System.out.println("Enter 0: Exit");
    }

    public void createClaim()
    {
        System.out.println("---------------------------------------");
        System.out.println("Create Claim:");

        System.out.print("Enter Claim ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Claim Date(dd/mm/yyyy): ");
        String claimDateStr = sc.nextLine();
        Date claimDate = new Date(claimDateStr);

        Customer insuredPerson;
        do
        {
            System.out.print("Enter Insured Person's ID: ");
            String insuredPersonId = sc.nextLine();
            insuredPerson = findCustomerById(insuredPersonId);
            if (insuredPerson == null) System.out.println("The ID does not exist!");
        } while (insuredPerson == null);

        String cardNumber = null;
        cardNumber = insuredPerson.getInsuranceCard().getCardNumber();

        System.out.print("Enter Examination Date(dd/mm/yyyy): ");
        String examDateStr = sc.nextLine();
        Date examDate = new Date(examDateStr);

        Set<String> documents = gatherDocuments(id, cardNumber);

        System.out.print("Enter Claim Amount: ");
        double claimAmount = sc.nextDouble();
        sc.nextLine();
        Status status = Status.NEW;                          //Set New for new claims
        System.out.println("Enter Receiver Banking Info:");
        System.out.print("Bank Name: ");
        String bankName = sc.nextLine();
        System.out.print("Owner Name: ");
        String ownerName = sc.nextLine();
        System.out.print("Account Number: ");
        String accountNumber = sc.nextLine();

        BankingInfo receiverBankingInfo = new BankingInfo(bankName, ownerName, accountNumber);

        Claims addedClaim = new Claims(id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, status, receiverBankingInfo);

        controller.addClaim(addedClaim);
        System.out.println("Successfully added claim");
        insuredPerson.addClaims(addedClaim);
    }

    public void updateClaim()
    {
        System.out.println("---------------------------------------");
        System.out.println("Updating Claim:");

        System.out.print("Enter claim ID: ");
        String claimId = sc.nextLine();
        Claims existingClaim = controller.getClaim(claimId);

        if (existingClaim == null)
        {
            System.out.println("Claim with ID " + claimId + " does not exist.");
            return;
        }

        Customer tmp = findCustomerById(existingClaim.getInsuredPerson().getId());
        tmp.removeClaim(existingClaim);
        controller.deleteClaim(claimId);

        System.out.print("Enter Claim ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Claim Date(dd/mm/yyyy): ");
        String claimDateStr = sc.nextLine();
        Date claimDate = new Date(claimDateStr);

        Customer insuredPerson;
        do
        {
            System.out.print("Enter Insured Person's ID: ");
            String insuredPersonId = sc.nextLine();
            insuredPerson = findCustomerById(insuredPersonId);
            if (insuredPerson == null) System.out.println("The ID does not exist");
        } while (insuredPerson == null);

        String cardNumber = null;

        cardNumber = insuredPerson.getInsuranceCard().getCardNumber();

        System.out.print("Enter Examination Date(dd/mm/yyyy): ");
        String examDateStr = sc.nextLine();
        Date examDate = new Date(examDateStr);

        Set<String> documents = gatherDocuments(id, cardNumber);

        System.out.print("Enter Claim Amount: ");
        double claimAmount = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter a Claim status: ");
        String status_str = sc.nextLine();
        Status status;
        if (status_str.equalsIgnoreCase("NEW"))
        {
            status = Status.NEW;
        }
        else if (status_str.equalsIgnoreCase("PROCESSING"))
        {
            status = Status.PROCESSING;
        }else
        {
            status = Status.DONE;
        }

        System.out.println("Enter Receiver Banking Info:");
        System.out.print("Bank Name: ");
        String bankName = sc.nextLine();
        System.out.print("Owner Name: ");
        String ownerName = sc.nextLine();
        System.out.print("Account Number: ");
        String accountNumber = sc.nextLine();

        BankingInfo bankingInfo = new BankingInfo(bankName, ownerName, accountNumber);

        Claims updatedClaim = new Claims (id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, status, bankingInfo);

        controller.updateClaim(updatedClaim);
        System.out.println("Successfully updated Claim");
        insuredPerson.addClaims(updatedClaim);
    }

    public void deleteClaim()
    {
        System.out.println("---------------------------------------");
        System.out.println("Deleting Claim:");

        System.out.print("Enter claim ID");
        String claimId = sc.nextLine();

        Claims existingClaim = controller.getClaim(claimId);

        if (existingClaim == null)
        {
            System.out.println("Claim ID " + claimId + " does not exist.");
            return;
        }

        System.out.println("You want to delete Claim ID" + claimId +"?");
        System.out.println("---------------------------------------");
        Claims.displayInfo(existingClaim);
        System.out.println("---------------------------------------");
        System.out.println("Enter 1: Yes");
        System.out.println("Enter 2: No");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1)
        {
            findCustomerById(existingClaim.getInsuredPerson().getId()).removeClaim(existingClaim);
            controller.deleteClaim(claimId);
            System.out.println("Successfully deleted Claim");
        } else { System.out.println("Canceled"); }
    }

    public void getOneClaim()
    {
        System.out.println("---------------------------------------");
        System.out.println("Get Claim:");

        System.out.print("Enter Claim ID");
        String claimId = sc.nextLine();

        Claims oneClaim = controller.getClaim(claimId);

        if (oneClaim == null) { System.out.println("Claim ID " + claimId + " does not exist."); }
        else { Claims.displayInfo(oneClaim); }
    }

    public void getAllClaims()
    {
        System.out.println("---------------------------------------");
        System.out.println("Get All Claims:");

        Set<Claims> claims = controller.getAllClaims();

        if (claims.isEmpty())
        {
            System.out.println("No claims found");
        } else
        {
            for (Claims claim : claims)
            {
                Claims.displayInfo(claim);
                System.out.println("---------------------------------------");
            }
        }
    }

    private Set<String> gatherDocuments(String claimId, String cardNumber)
    {
        Set<String> documents = new HashSet<>();

        System.out.print("Enter the number of documents:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Document Name for Document " + i + ":");
            String documentName = sc.nextLine();
            String documentFileName = claimId + "_" + cardNumber + "_" + documentName + ".pdf";
            documents.add(documentFileName);
        }

        return documents;
    }
    private Customer findCustomerById(String id)
    {
        return controller.getCustomerById(id);
    }


}