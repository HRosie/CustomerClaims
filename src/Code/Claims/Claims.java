package Code.Claims;

import Code.Customer.*;

import java.util.Date;
import java.util.List;

public class Claims {
    private String claimID;
    private Date claimDate;
    private Date examDate;
    private Customer insurancePeople;
    private InsuranceID insuranceID;
    private final int documentNumbers;
    private List<String> documents;
    private double claimAmount;
    private Status status;
    private BankingInfo bankInfo;

    public Claims(String claimID, Date claimDate, Date examDate, Customer insurancePeople, InsuranceID insuranceID, int documentNumbers, List<String> documents, double claimAmount, Status status, BankingInfo bankInfo) {
        this.claimID = claimID;
        this.claimDate = claimDate;
        this.examDate = examDate;
        this.insurancePeople = insurancePeople;
        this.insuranceID = insuranceID;
        this.documentNumbers = documents.size();
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.bankInfo = bankInfo;
    }

    public String getClaimID() {
        return claimID;
    }

    public void setClaimID(String claimID) {
        this.claimID = claimID;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Customer getInsurancePeople() {
        return insurancePeople;
    }

    public void setInsurancePeople(Customer insurancePeople) {
        this.insurancePeople = insurancePeople;
    }

    public InsuranceID getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(InsuranceID insuranceID) {
        this.insuranceID = insuranceID;
    }
    public int getDocumentNumbers() { return documentNumbers; }
    public void setDocumentNumbers() {}
    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Status getStatus() { return status; }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BankingInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankingInfo bankInfo) {
        this.bankInfo = bankInfo;
    }



    /*public void display() {
        System.out.println("ClaimID: " + claimID + "            Claim Date: " + claimDate);
        System.out.println("-------------");
        System.out.println("Insured People: " + insurancePeople + "            Exam Date: " + examDate);
        System.out.println("Card Number: " + insuranceID.getCardNumber());
        System.out.println("List of Documents:: ");
        for (String document : documents) {
            System.out.println("- " + document);
        }
        System.out.println("-------------");
        System.out.print("Claim Amount: " + claimAmount);
        System.out.println("Status: " + status);
        System.out.println("Receiver Banking Info:         Bank: " + bankInfo.getBank() + "           Name: " + bankInfo.getName());
        System.out.println("                                  Number: " + bankInfo.getNumber());
        System.out.println("--------------------------");
    }*/

}
