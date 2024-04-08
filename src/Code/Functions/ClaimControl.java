package Code.Functions;

import Code.Claims.*;
import Code.Customer.*;
import Code.Manager.*;
import Code.Files.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class ClaimControl
{
    private ClaimProcessManager manage;
    private ClaimProcessManagerImpl manager;
    private ClaimMenu menu;
    private SaveData save;
    private LoadData load;


    public ClaimControl(ClaimProcessManager manage, ClaimMenu menu,SaveData save,LoadData load, ClaimProcessManagerImpl manager)
    {
        this.manage = manage;
        this.manager = manager;
        this.menu = menu;
        this.save = save;
        this.load = load;
    }

    public void setMenu(ClaimMenu menu)
    {
        this.menu = menu;
    }

    public void application() throws IOException {
        int choice;

        Scanner sc = new Scanner(System.in);
        Set<Customer> customers = load.loadCustomers("src/Code/Storage/Customers.txt");
        for (Customer customer:customers)
        {
            manager.addCustomer(customer);
            Set<Claims> claims = customer.getClaims();
            for (Claims claim : claims)
            {
                claim.setInsuredPerson(customer);
                manage.add(claim);
            }
        }
        do
        {
            menu.displayMenu();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    menu.createClaim();
                    break;
                case 2:
                    menu.updateClaim();
                    break;
                case 3:
                    menu.deleteClaim();
                    break;
                case 4:
                    menu.getOneClaim();
                    break;
                case 5:
                    menu.getAllClaims();
                    break;
                case 0:
                    save.saveCustomers(getAllCustomers(),"src/Code/Storage/Customers.txt");
                    save.saveClaims(getAllClaims(),"src/Code/Storage/Claims.txt");
                    save.saveInsuranceCard(getAllCustomers(),"src/Code/Storage/Insurance.txt");
                    save.saveBankingInfo(getAllClaims(),"src/Code/Storage/BankInfo.txt");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public void addClaim(Claims claim)
    {
        manage.add(claim);
    }
    public void updateClaim(Claims claim)
    {
        manage.update(claim);
    }
    public Claims getClaim(String id)
    {
        return manage.getOne(id);
    }
    public void deleteClaim(String claimId)
    {
        manage.delete(claimId);
    }
    public Customer getCustomerById(String id)
    {
        return manage.getCustomerById(id);
    }

    public Set<Claims> getAllClaims()
    {
        return manage.getAll();
    }

    public Set <Customer> getAllCustomers()
    {
        return manage.getAllCustomer();
    }

}
