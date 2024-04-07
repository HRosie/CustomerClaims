package Code.Functions;

import Code.Claims.*;
public class ClaimView {

    public static void displayClaim(Claims claim) {
        System.out.println("Claim ID: " + claim.getClaimID());
        System.out.println("Claim Date: " + claim.getClaimDate());
        System.out.println("Insured Person: " + claim.getInsurancePeople().getCustomerName());
        System.out.println("Card Number: " + claim.getInsurancePeople().getInsuranceCardID());
        System.out.println("Exam Date: " + claim.getExamDate());
        System.out.println("Documents:");
        for (String document : claim.getDocuments()) {
            System.out.println("- " + document);
        }
        System.out.println("Claim Amount: " + claim.getClaimAmount());
        System.out.println("Status: " + claim.getStatus());
        BankingInfo bankInfo = claim.getBankInfo();
        System.out.println("Receiver Banking Info:");
        System.out.println("Bank: " + bankInfo.getBank());
        System.out.println("Name: " + bankInfo.getName());
        System.out.println("Number: " + bankInfo.getNumber());
        System.out.println("------------------------------");
    }
}