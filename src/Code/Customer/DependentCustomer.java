package Code.Customer;

import Code.Claims.*;

import java.util.List;

public class DependentCustomer extends Customer{
    private PolicyHolder holderName;

    public DependentCustomer(String customerID, String customerName, String customerType, InsuranceID insuranceID, List<Claims> claim, PolicyHolder holderName) {
        super(customerID,customerName, customerType, insuranceID, claim );
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
    //@Override
    public void display() {
        System.out.println("Holder name: " + holderName.getName());
    }
}
