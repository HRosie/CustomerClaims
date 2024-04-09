package Code.Customer;

import Code.Claims.Claims;

import java.util.Set;

public class DependentCustomer extends Customer
{
    public DependentCustomer(String id, String fullName, InsuranceID insuranceId, Set<Claims> claims)
    {
        super(id, fullName, insuranceId,claims);
    }
}
