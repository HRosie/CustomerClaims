package Code.Functions;

import java.util.Set;
import Code.Claims.*;
import Code.Customer.*;
public class ClaimView {

    public static void displayClaim(Claims claim) {
        System.out.println("Claim ID: " + claim.getClaimID());
        System.out.println("Claim Date: " + claim.getClaimDate());
        System.out.println("Insured Person: " + claim.getInsurancePeople().getName());
        System.out.println("Card Number: " + claim.getInsuranceID());
        System.out.println("Exam Date: " + claim.getExamDate());
        System.out.println("Documents:");
        for (String document : claim.getDocuments()) {
            System.out.println("- " + document);
        }
        System.out.println("Claim Amount: " + claim.getClaimAmount());
        System.out.println("Status: " + claim.getStatus());
        BankingInfo receiverBankingInfo = claim.getBankInfo();
        System.out.println("Receiver Banking Info:");
        System.out.println("Bank: " + receiverBankingInfo.getBank());
        System.out.println("Name: " + receiverBankingInfo.getName());
        System.out.println("Number: " + receiverBankingInfo.getNumber());
        System.out.println("------------------------------");
    }
}