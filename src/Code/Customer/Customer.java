package Code.Customer;

import Code.Claims.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Customer
{
    private String id;
    private  String fullname;
    private InsuranceID insuranceCard;
    private Set<Claims> claims;

    public Customer(String id, String fullname, InsuranceID insuranceCard, Set<Claims> claims) {
        this.id = id;
        this.fullname = fullname;
        this.insuranceCard = insuranceCard;
        this.claims = claims != null ? claims : new HashSet<>();
    }

    public InsuranceID   getInsuranceCard()
    {
        return insuranceCard;
    }

    public String getId()
    {
        return id;
    }

    public String getFullname()
    {
        return fullname;
    }

    public void addClaim(Claims claim)
    {
        claims.add(claim);
    }

    public void  removeClaim(Claims claim) {claims.remove(claim);}

    public Set<Claims> getClaims()
    {
        return claims;
    }

}
