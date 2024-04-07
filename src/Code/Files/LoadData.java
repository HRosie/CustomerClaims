package Code.Files;

import Code.Claims.*;
import Code.Customer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoadData {

    public static void main(String[] args) {
        String claimsFilePath = "Storage/Claims.txt";
        String customerFilePath = "Storage/Customer.txt";
        String insuranceFilePath = "Storage/InsuranceID.txt";
        String bankInfoFilePath = "Storage/bankInfo.txt";
        List<Claims> claimsList = loadClaims(claimsFilePath, customerFilePath, insuranceFilePath, bankInfoFilePath);
        // Use the loaded claims data...
    }

    public static List<Claims> loadClaims(String claimsFilePath, String customerFilePath, String insuranceFilePath, String bankInfoFilePath) {
        List<Claims> claimsList = new ArrayList<>();

        List<Customer> customers = loadCustomers(customerFilePath);
        List<InsuranceID> insuranceIDs = loadInsuranceIDs(insuranceFilePath);
        List<BankingInfo> bankingInfos = loadBankInfo(bankInfoFilePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(claimsFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String claimID = data[0];
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date claimDate = dateFormat.parse(data[1]);
                Date examDate = dateFormat.parse(data[2]);
                String customerName = data[3];
                int documentNumbers = Integer.parseInt(data[4]);
                List<String> documents = new ArrayList<>();
                for (int i = 0; i < documentNumbers; i++) {
                    documents.add(data[5 + i]);
                }
                double claimAmount = Double.parseDouble(data[5 + documentNumbers]);
                Status status = Status.valueOf(data[6 + documentNumbers]);
                String bankName = data[7 + documentNumbers];
                String accountHolderName = data[8 + documentNumbers];
                String accountNumber = data[9 + documentNumbers];

                Customer customer = findCustomerByName(customerName, customers);
                if (customer == null) {
                    continue;
                }

                InsuranceID insuranceID = findInsuranceByID(customer, insuranceIDs);
                if (insuranceID == null) {
                    continue;
                }

                BankingInfo bankInfo = findBankInfoByName(bankName, bankingInfos);
                if (bankInfo == null) {
                    continue;
                }

                Claims claim = new Claims(claimID, claimDate, examDate, customer, insuranceID, documentNumbers, documents, claimAmount, status, bankInfo);
                claimsList.add(claim);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return claimsList;
    }

    private static List<Customer> loadCustomers(String customerFilePath) {
        List<Customer> customers = new ArrayList<>();
        // Implement loading customers from file
        return customers;
    }

    private static List<InsuranceID> loadInsuranceIDs(String insuranceFilePath) {
        List<InsuranceID> insuranceIDs = new ArrayList<>();
        // Implement loading insurance IDs from file
        return insuranceIDs;
    }

    private static List<BankingInfo> loadBankInfo(String bankInfoFilePath) {
        List<BankingInfo> bankingInfos = new ArrayList<>();
        // Implement loading bank info from file
        return bankingInfos;
    }

    private static Customer findCustomerByName(String customerName, List<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }

    private static InsuranceID findInsuranceByID(Customer customer, List<InsuranceID> insuranceIDs) {
        for (InsuranceID insuranceID : insuranceIDs) {
            if (insuranceID.getCardHolder().equals(customer)) {
                return insuranceID;
            }
        }
        return null;
    }

    private static BankingInfo findBankInfoByName(String bankName, List<BankingInfo> bankingInfos) {
        for (BankingInfo bankInfo : bankingInfos) {
            if (bankInfo.getBank().equals(bankName)) {
                return bankInfo;
            }
        }
        return null;
    }
}