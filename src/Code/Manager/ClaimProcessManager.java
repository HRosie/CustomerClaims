package Code.Manager;

import Code.Claims.*;
import Code.Customer.*;

import java.util.Set;
public interface ClaimProcessManager
{
    void add(Claims claim);
    void update(Claims claim);
    void delete(String id);
    Claims getOne(String id);
    Set<Claims> getAll();

    Set<Customer> getAll_C();
    Customer getCustomerById(String id);
}
