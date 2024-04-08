package Code.Claims;

import Code.Customer.*;
import Code.Functions.Date;

import java.util.Set;

public class Claims
{
    private String id;
    private Date claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private Date examDate;
    private Set<String> documents;
    private double claimAmount;
    private Status status;
    private BankingInfo BankingInfo;

    public Claims(String id, Date claimDate, Customer insuredPerson, String cardNumber, Date examDate, Set<String> documents, double claimAmount, Status status, BankingInfo BankingInfo)
    {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.BankingInfo = BankingInfo;
    }

    public String getId()
    {
        return id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public Customer getInsuredPerson()
    {
        return insuredPerson;
    }

    public String getInsuranceID()
    {
        return cardNumber;
    }

    public Date getExamDate()
    {
        return examDate;
    }

    public Set<String> getDocuments()
    {
        return documents;
    }

    public double getClaimAmount()
    {
        return claimAmount;
    }

    public Status getStatus()
    {
        return status;
    }

    public BankingInfo getBankingInfo()
    {
        return BankingInfo;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public static void displayInfo(Claims claim)
    {
        System.out.println("Claim ID: " + claim.getId());
        System.out.println("Claim Date: " + claim.getClaimDate().toString());
        System.out.println("Insured Person: " + claim.getInsuredPerson().getName());
        System.out.println("Card Number: " + claim.getInsuranceID());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("List of Documents:");
        if (claim.getDocuments() != null) {
            for (String document : claim.getDocuments()) {
                System.out.println("- " + document);
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Claim Amount: " + claim.getClaimAmount());
        System.out.println("Claim Status: " + claim.getStatus());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Receiver Banking Info: ");
        BankingInfo bankInfo = claim.getBankingInfo();
        System.out.println("Bank Name: " + bankInfo.getBankName());
        System.out.println("Owner Name: " + bankInfo.getOwnerName());
        System.out.println("Account Number: " + bankInfo.getNumber());

    }
}
