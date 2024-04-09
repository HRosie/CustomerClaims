package Code.Customer;

import Code.Claims.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Customer
{
    private String customerId;
    private  String name;
    private InsuranceID insuranceCard;
    private Set<Claims> claims;

    public Customer(String customerId, String name, InsuranceID insuranceCard, Set<Claims> claims) {
        this.customerId = customerId;
        this.name = name;
        this.insuranceCard = insuranceCard;
        this.claims = claims != null ? claims : new HashSet<>();
    }

    public InsuranceID   getInsuranceCard()
    {
        return insuranceCard;
    }

    public String getId()
    {
        return customerId;
    }

    public String getName()
    {
        return name;
    }

    public void addClaims(Claims claim)
    {
        claims.add(claim);
    }

    public void  removeClaim(Claims claim) {claims.remove(claim);}

    public Set<Claims> getClaims()
    {
        return claims;
    }

}
