package Code.Customer;

import Code.Claims.Claims;
import Code.InsuranceID.InsuranceID;

import java.util.List;

public class DependentCustomer extends Customer{
    private PolicyHolder holderName;
    public DependentCustomer(String customerID, String customerName, InsuranceID insuranceID, List<Claims> claim, PolicyHolder holderName) {
        super(customerID,customerName,insuranceID, claim );
        this.holderName = holderName;
    }


    public void setHolderName(PolicyHolder holderName) {
        this.holderName = holderName;
    }

    public PolicyHolder getHolderName() {
        return holderName;
    }

    public String getName() {
        return super.getCustomerName();
    }

    public String getCustomerType() {
        return "Dependent";
    }

    //@Override
    public void display() {
        System.out.println("Holder name: " + holderName.getName());
    }
}
