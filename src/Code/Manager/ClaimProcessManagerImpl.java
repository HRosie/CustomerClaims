package Code.Manager;

import Code.Customer.*;
import Code.Claims.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClaimProcessManagerImpl implements ClaimProcessManager
{
    private Map<String, Claims> claims;
    private Set<Customer> customers;

    public ClaimProcessManagerImpl()
    {
        this.claims = new HashMap<>();
        this.customers = new HashSet<>();
    }
    @Override
    public void add(Claims claim)
    {
        claims.put(claim.getId(), claim);
    }
    @Override
    public void update(Claims claim)
    {
        claims.put(claim.getId(), claim);
    }
    @Override
    public void delete(String id)
    {
        claims.remove(id);
    }
    @Override
    public Claims getOne(String id)
    {
        return claims.get(id);
    }

    @Override
    public Set<Claims> getAll()
    {
        Set<Claims> claimSet = new HashSet<>(claims.values());
        List<Claims> claimList = new ArrayList<>(claimSet);
        Collections.sort(claimList, Comparator.comparing(Claims::getId).reversed());
        Set<Claims> sortedClaims = new HashSet<Claims>(claimList);

        return sortedClaims;
    }

    @Override
    public Set<Customer> getAllCustomer()
    {
        return customers;
    }
    @Override
    public Customer getCustomerById(String id)
    {
        for (Customer customer : customers)
        {
            if (customer.getId().equals(id)) { return customer;}
        }
        return null;
    }
    public void addCustomer(Customer customer) { customers.add(customer);}

}
