package Code.Customer;

import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer {
    private List<DependentCustomer> dependentCustomers;

    public PolicyHolder(String id, String name, String card, List<DependentCustomer> dependentCustomers) {
        super(id,name,card);
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
        return super.getName();
    }

    public String getCustomerType() {
        return "Policy Holder";
    }

    public void display() {
        super.displayCustomer();
        System.out.println("Customer Type: Policy Holder");
        System.out.println("Dependent Customer List:");
        for (DependentCustomer dependent : dependentCustomers) {
            System.out.print("- Name: " + dependent.getName());

        }
    }
}
