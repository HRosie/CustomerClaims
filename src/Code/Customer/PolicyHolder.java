package Code.Customer;

import Code.Claims.Claims;

import java.util.HashSet;
import java.util.Set;

public class PolicyHolder extends Customer
{
    private Set<DependentCustomer> dependents;

    public PolicyHolder(String id, String fullName, InsuranceID insuranceCard,
                        Set<Claims> claims, Set<DependentCustomer> dependents)
    {
        super(id, fullName, insuranceCard,claims);
        this.dependents = new HashSet<>(dependents);
    }

    public void setDependents(Set<DependentCustomer> dependents) {
        this.dependents = dependents;
    }

    public Set<DependentCustomer> getDependents() {
        return dependents;
    }
}
