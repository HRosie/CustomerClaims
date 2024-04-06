package Code.Customer;

import Code.Claims.Claims;
import Code.Claims.ClaimsView;

public class CustomersView {
    public void displayCustomerAll(Customer customer) {
        System.out.println("Name: " + customer.getCustomerName());
        System.out.println("CustomerID: " + customer.getCustomerId() + "        Customer Type: " + customer.getCustomerType());
        if (customer instanceof PolicyHolder policyHolder) {
            policyHolder.display();
        }
        else {
            DependentCustomer dependentCustomer = (DependentCustomer) customer;
            dependentCustomer.display();
        }
        System.out.println("----------------------------------------");
        System.out.println("Insurance Card:");
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
