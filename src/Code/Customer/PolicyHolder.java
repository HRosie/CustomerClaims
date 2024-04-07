package Code.Customer;

import Code.Claims.*;

import java.util.List;

public class PolicyHolder extends Customer {
    private List<DependentCustomer> dependentCustomers;

    public PolicyHolder(String customerID, String customerName, String customerType, InsuranceID insuranceID, List<Claims> claims, List<DependentCustomer> dependentCustomers) {
        super(customerID,customerName, customerType, insuranceID, claims);
        this.dependentCustomers = dependentCustomers;
    }

    public void setDependentCustomers(List<DependentCustomer> dependentCustomers) {
        this.dependentCustomers = dependentCustomers;
    }
    /*public void addDependentCustomer(DependentCustomer dependentCustomer) {
        dependentCustomers.add(dependentCustomer);
    }*/

    public List<DependentCustomer> getDependentCustomers() {
        return dependentCustomers;
    }

    public String getName() {
        return super.getCustomerName();
    }

    public void display() {
        System.out.println("Dependent Customer List:");
        for (DependentCustomer dependent : dependentCustomers) {
            System.out.print("- Name: " + dependent.getName());
        }
    }
}
