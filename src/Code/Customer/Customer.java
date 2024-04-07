package Code.Customer;


import Code.Claims.Claims;
import Code.Claims.ClaimsView;
import Code.InsuranceID.InsuranceID;

import java.util.List;

public class Customer {
    protected String customerId;
    protected String customerName;
    protected InsuranceID insuranceCardID;
    private List<Claims> claims;

    public Customer(String customerId, String customerName, InsuranceID insuranceCardID, List<Claims> claims) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.insuranceCardID = insuranceCardID;
        this.claims = claims;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public InsuranceID getInsuranceCardID() {
        return insuranceCardID;
    }

    public void setInsuranceCardID(InsuranceID insuranceCardID) {
        this.insuranceCardID = insuranceCardID;
    }

    public List<Claims> getClaims() {
        return claims;
    }

    public void setClaims(List<Claims> claims) {
        this.claims = claims;
    }
    public void setCardHolder(String cardHolder) {
        this.customerName = cardHolder;
    }
    public void setPolicyOwner(String policyOwner) {
        this.customerName = policyOwner;
    }

    public String getCustomerType() {
        return null;
    }

    public void displayCustomerOne(Customer customer) {
        System.out.println("Name: " + customerName);
        System.out.println("CustomerID: " + customerId + "        Customer Type: " + getCustomerType());
        if (customer instanceof PolicyHolder policyHolder) {
            policyHolder.display();
        }
        else {
            DependentCustomer dependentCustomer = (DependentCustomer) customer;
            dependentCustomer.display();
        }
        System.out.println("----------------------------------------");
        System.out.println("Insurance Card:");
        insuranceCardID.display();
        System.out.println("----------------------------------------");
        /* System.out.println("Card Number: " + insuranceCardID.getCardNumber());
        System.out.println("Policy Owner: " + insuranceCardID.getPolicyOwner().getName());
        System.out.println("Expiration Date: " + insuranceCardID.getExpDate());*/
        System.out.println("Claim List: ");
        for (Claims claim : claims) {
            ClaimsView.displayClaim(claim);
        }
    }
}
