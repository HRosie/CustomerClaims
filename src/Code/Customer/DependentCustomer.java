package Code.Customer;

import Code.Claims.Claims;

import java.util.Set;

public class DependentCustomer extends Customer
{
    public DependentCustomer(String id, String fullName, InsuranceID insuranceCard,
                     Set<Claims> claims)
    {
        super(id, fullName, insuranceCard,claims);
    }
}
