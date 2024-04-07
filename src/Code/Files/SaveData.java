package Code.Files;

import Code.Claims.*;
import Code.Customer.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

public class SaveData {
    public static void saveCustomers(Set<Customer> customers, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                writer.write(customerToString(customer));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String customerToString(Customer customer) {
        return String.format("%s,%s,%s,%s,%s",
                customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getInsuranceCardID().getCardNumber(),
                customer.getInsuranceCardID().getPolicyOwner(),
                customer.getClaims().size());
    }

    public static void saveClaimsData(List<Claims> claims, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(claims);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static void saveInsuranceIDData(List<InsuranceID> insuranceIDs, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (InsuranceID insuranceID : insuranceIDs) {
                writer.write(insuranceIDToString(insuranceID));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String insuranceIDToString(InsuranceID insuranceID) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return String.format("%s,%s,%s,%s",
                insuranceID.getCardNumber(),
                insuranceID.getCardHolder().getCustomerId(),
                insuranceID.getPolicyOwner(),
                dateFormat.format(insuranceID.getExpDate()));
    }
}