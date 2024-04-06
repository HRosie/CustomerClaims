package Code.Customer;

import java.util.List;
import Code.Claims.Claims;
import Code.InsuranceID.InsuranceID;

public class PolicyHolder extends Customer {
    private List<DependentCustomer> dependentCustomers;

    public PolicyHolder(String customerID, String customerName, InsuranceID insuranceID, List<Claims> claims, List<DependentCustomer> dependentCustomers) {
        super(customerID,customerName,insuranceID, claims);
        this.dependentCustomers = dependentCustomers;
    }

    public void setDependentCustomers(List<DependentCustomer> dependentCustomers) {
        this.dependentCustomers = dependentCustomers;
    }
    public void addDependentCustomer(DependentCustomer dependentCustomer) {
        dependentCustomers.add(dependentCustomer);
    }

    public List<DependentCustomer> getDependentCustomers() {
        return dependentCustomers;
    }

    public String getName() {
        return super.getCustomerName();
    }

    public String getCustomerType() {
        return "Policy Holder";
    }

    public void display() {
        System.out.println("Dependent Customer List:");
        for (DependentCustomer dependent : dependentCustomers) {
            System.out.print("- Name: " + dependent.getName());
        }
    }
}
