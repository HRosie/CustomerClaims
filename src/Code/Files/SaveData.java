package Code.Files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import Code.Claims.*;
import Code.Customer.*;
import Code.InsuranceID.*;

public class SaveData {

    public static void saveClaimsData(List<Claims> claimsList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Claims claim : claimsList) {
                writer.write(claimToString(claim));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String claimToString(Claims claim) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String documents = String.join(",", claim.getDocuments());
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                claim.getClaimID(),
                dateFormat.format(claim.getClaimDate()),
                dateFormat.format(claim.getExamDate()),
                claim.getInsurancePeople().getCustomerId(),
                claim.getInsurancePeople().getCustomerName(),
                claim.getInsuranceID().getCardNumber(),
                claim.getInsuranceID().getPolicyOwner(),
                documents,
                claim.getClaimAmount(),
                claim.getStatus().name(),
                claim.getBankInfo().getBank(),
                claim.getBankInfo().getName(),
                claim.getBankInfo().getNumber());
    }

    public static void saveCustomerData(List<Customer> customers, String filePath) {
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
        return String.format("%s,%s,%s,%s",
                customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getInsuranceCardID().getCardNumber(),
                customer.getClaims().size());
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