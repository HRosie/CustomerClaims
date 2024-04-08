package Code.Claims;

import Code.Customer.*;

import java.util.Set;
import java.util.Date;

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
    private BankingInfo receiverBankingInfo;

    public Claims(String id, Date claimDate, Customer insuredPerson, String cardNumber,
                 Date examDate, Set<String> documents, double claimAmount,
                 Status status, BankingInfo receiverBankingInfo)
    {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankingInfo = receiverBankingInfo;
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

    public String getCardNumber()
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
        return receiverBankingInfo;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }
}
