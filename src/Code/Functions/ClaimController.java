package Code.Functions;

import Code.Customer.*;
import Code.Manager.*;
import Code.Claims.*;
import Code.Files.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class ClaimController
{
    private ClaimProcessManager manage;
    private ClaimProcessManagerImpl manager;
    private ClaimView view;
    private SaveData save;
    private LoadData load;


    public ClaimController(ClaimProcessManager manage, ClaimView view,SaveData save,LoadData load, ClaimProcessManagerImpl manager)
    {
        this.manage = manage;
        this.manager = manager;
        this.view = view;
        this.save = save;
        this.load = load;
    }

    public void setView(ClaimView view)
    {
        this.view = view;
    }

    public void application() throws IOException {
        int choice;

        Scanner sc = new Scanner(System.in);
        Set<Customer> customers = load.loadCustomers("src/Code/Storage/Customers");
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
            view.displayMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    view.createClaimForm();
                    break;
                case 2:
                    view.updateClaim();
                    break;
                case 3:
                    view.deleteClaim();
                    break;
                case 4:
                    view.getSpecifiedClaim();
                    break;
                case 5:
                    view.getAllClaims();
                    break;
                case 0:
                    save.saveCustomers(getAllCustomers(),"src/Code/Storage/Customers.txt");
                    save.saveClaims(getAllClaims(),"src/Code/Storage/Claims.txt");
                    save.saveInsuranceCard(getAllCustomers(),"src/Code/Storage/Insurance.txt");
                    save.saveReceiverBankingInfo(getAllClaims(),"src/Code/Storage/BankInfo.txt");
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
    public Claims    getClaim(String id)
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
        return manage.getAll_C();
    }

}
