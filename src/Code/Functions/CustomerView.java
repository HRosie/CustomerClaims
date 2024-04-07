package Code.Functions;

import Code.Customer.*;
import Code.InsuranceID.*;
import Code.Claims.*;

public class CustomerView {
    public static void displayCustomer(Customer customer) {
        System.out.println("Name: " + customer.getCustomerName()
        );
        System.out.println("CustomerID: " + customer.getCustomerId() + "        Customer Type: " + customer.getCustomerType());
        if (customer instanceof PolicyHolder policyHolder) {
            policyHolder.display();
        }
        else {
            DependentCustomer dependentCustomer = (DependentCustomer) customer;
            dependentCustomer.display();
        }
        System.out.println("----------------------------------------");
        System.out.println("Insurance Card Information:");
        customer.getInsuranceCardID().display();
        System.out.println("----------------------------------------");
        /* System.out.println("Card Number: " + insuranceCardID.getCardNumber());
        System.out.println("Policy Owner: " + insuranceCardID.getPolicyOwner().getName());
        System.out.println("Expiration Date: " + insuranceCardID.getExpDate());*/
        System.out.println("Claim List: ");
        for (Claims claim : customer.getClaims()) {
            ClaimsView.displayClaim(claim);
        }
    }
}