package Code.InsuranceID;

import Code.Customer.Customer;
import Code.Customer.PolicyHolder;
import java.util.Date;

public class InsuranceID {
    private String cardNumber;
    private Customer cardHolder;
    private String policyOwner;
    private Date expDate;

    public InsuranceID(String cardNumber, Customer cardHolder, String policyOwner, Date expDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expDate = expDate;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "Card Number: " + cardNumber + ", Card Holder: " + cardHolder.getCustomerName() +
                ", Policy Owner: " + policyOwner + ", Expiration Date: " + expDate;
    }

    public void display() {
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Card Holder: " + cardHolder);
        System.out.println("Policy Owner: " + policyOwner);
        System.out.println("Expiration Date: " + expDate);
    }
}
