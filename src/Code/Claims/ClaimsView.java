package Code.Claims;

public class ClaimsView {
    public static void displayClaim(Claims claim) {
        System.out.println("ClaimID: " + claim.getClaimID() + "            Claim Date: " + claim.getClaimID());
        System.out.println("-------------");
        System.out.println("Insured People: " + claim.getInsurancePeople() + "            Exam Date: " + claim.getExamDate());
        System.out.println("Card Number: " + claim.getInsuranceID().getCardNumber());
        System.out.println("List of Documents:: ");
        for (String document : claim.getDocuments()) {
            System.out.println("- " + document);
        }
        System.out.println("-------------");
        System.out.print("Claim Amount: " + claim.getClaimAmount());
        System.out.println("Status: " + claim.getStatus());
        System.out.println("Receiver Banking Info:         Bank: " + claim.getBankInfo().getBank() + "           Name: " + claim.getBankInfo().getName());
        System.out.println("                                  Number: " + claim.getBankInfo().getNumber());
        System.out.println("--------------------------");
    }
}
