package Code.Customer;


import Code.Claims.Claims;
import java.util.List;

public class Customer {
    private String customerId;
    private String customerName;
    private String insuranceCardID;
    private List<Claims> claims;

    public Customer(String id, String name, String card){
        this.customerId = id;
        this.customerName = name;
        this.insuranceCardID = card;
    }
    public String getId() { return this.customerId; }

    public void setID(String customerId) {
        this.customerId = customerId;
    }

    public String getName() { return this.customerName; }

    public void setName(String customerName) {
        this.customerName = customerName;
    }

    public String getInsuranceCard() {
        return insuranceCardID;
    }

    public void setInsuranceCard() { this.insuranceCardID = insuranceCardID;
    }

    public void displayCustomer() {
        System.out.println("Name: " + customerName);
        System.out.println("CustomerID: " + customerId);
        System.out.println("Insurance Card: " + insuranceCardID);
        System.out.println("Claim List: ");
        for (Claims claims : claims) {
            super.displayClaimsCustomer();
        }
    }
}
