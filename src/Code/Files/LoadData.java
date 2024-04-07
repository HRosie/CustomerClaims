package Code.Files;

import Code.Customer.*;
import Code.Claims.*;
import Code.InsuranceID.InsuranceID;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoadData {

    public static List<Claims> loadClaimsData(String filePath) {
        List<Claims> claimsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Claims claim = parseClaim(line);
                if (claim != null) {
                    claimsList.add(claim);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return claimsList;
    }

    private static Claims parseClaim(String line) throws ParseException {
        String[] parts = line.split(",");
        if (parts.length != 13) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String claimID = parts[0];
        Date claimDate = dateFormat.parse(parts[1]);
        Date examDate = dateFormat.parse(parts[2]);
        String customerID = parts[3];
        String customerName = parts[4];
        String cardNumber = parts[5];
        String policyOwner = parts[6];
        String[] documents = parts[7].split(",");
        double claimAmount = Double.parseDouble(parts[8]);
        Status status = Status.valueOf(parts[9]);
        String bank = parts[10];
        String name = parts[11];
        String number = parts[12];

        Customer insurancePeople = new Customer(customerID, customerName, null, null);
        InsuranceID insuranceID = new InsuranceID(cardNumber, insurancePeople, policyOwner, null);
        List<String> documentList = new ArrayList<>();
        for (String doc : documents) {
            documentList.add(doc);
        }
        BankingInfo bankInfo = new BankingInfo(bank, name, number);

        return new Claims(claimID, claimDate, examDate, insurancePeople, insuranceID, documentList, claimAmount, status, bankInfo);
    }

    public static List<Customer> loadCustomerData(String filePath) {
        List<Customer> customerList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Customer customer = parseCustomer(line);
                if (customer != null) {
                    customerList.add(customer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    private static Customer parseCustomer(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            return null;
        }

        String customerID = parts[0];
        String customerName = parts[1];
        String cardNumber = parts[2];
        int claimsCount = Integer.parseInt(parts[3]);
        // You may want to load claims data here for the customer, but since we're only parsing customer data, claims list is null for now
        return new Customer(customerID, customerName, new InsuranceID(cardNumber, null, null, null), null);
    }

    public static List<InsuranceID> loadInsuranceIDData(String filePath) {
        List<InsuranceID> insuranceIDList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                InsuranceID insuranceID = parseInsuranceID(line);
                if (insuranceID != null) {
                    insuranceIDList.add(insuranceID);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return insuranceIDList;
    }

    private static InsuranceID parseInsuranceID(String line) throws ParseException {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            return null;
        }

        String cardNumber = parts[0];
        String customerID = parts[1];
        String policyOwner = parts[2];
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date expDate = dateFormat.parse(parts[3]);
        // You may want to load customer data here for the insurance ID, but since we're only parsing insurance ID data, customer is null for now
        return new InsuranceID(cardNumber, null, policyOwner, expDate);
    }
}