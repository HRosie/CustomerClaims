package Code.Customer;

import Code.Claims.*;

import java.util.HashSet;
import java.util.Set;

public class PolicyHolder extends Customer
{
    private Set<DependentCustomer> dependents;

    public PolicyHolder(String id, String fullName, InsuranceID insuranceId, Set<Claims> claims, Set<DependentCustomer> dependents)
    {
        super(id, fullName, insuranceId,claims);
        this.dependents = new HashSet<>(dependents);
    }

    public void setDependents(Set<DependentCustomer> dependents) { this.dependents = dependents; }

    public Set<DependentCustomer> getDependents() {
        return dependents;
    }
}
