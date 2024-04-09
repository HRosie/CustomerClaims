package Code.Files;

import Code.Claims.*;
import Code.Customer.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class SaveData
{
    public void saveCustomers(Set<Customer> customers, String filePath) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            for (Customer customer : customers) {
                StringBuilder lineBuilder = new StringBuilder();
                lineBuilder.append(customer.getId()).append(",").append(customer.getName()).append(",")
                        .append((customer instanceof PolicyHolder ? "PolicyHolder" : "Dependent")).append(",")
                        .append(customer.getInsuranceCard().getCardNumber());

                if (customer instanceof PolicyHolder) {
                    PolicyHolder policyHolder = (PolicyHolder) customer;
                    StringBuilder dependentIds = new StringBuilder();
                    for (DependentCustomer dependent : policyHolder.getDependents()) {
                        dependentIds.append(dependent.getId()).append(";");
                    }
                    lineBuilder.append(",").append(dependentIds.toString());
                } else {
                    lineBuilder.append(",");
                }

                if (!customer.getClaims().isEmpty()) {
                    StringBuilder claimIds = new StringBuilder();
                    for (Claims claim : customer.getClaims()) {
                        claimIds.append(claim.getId()).append(";");
                    }
                    lineBuilder.append(",").append(claimIds.toString());
                } else {
                    lineBuilder.append(",");
                }

                writer.write(lineBuilder.toString());
                writer.newLine();
            }
        }
    }

    public void saveClaims(Set<Claims> claims, String filePath) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            for (Claims claim : claims) {
                StringBuilder lineBuilder = new StringBuilder();
                lineBuilder.append(claim.getId()).append(",").append(claim.getClaimDate().toString()).append(",")
                        .append((claim.getInsuredPerson().getId())).append(",")
                        .append(claim.getInsuranceID()).append(",").append((claim.getExamDate().toString())).append(",")
                        .append((claim.getClaimAmount())).append(",").append((claim.getStatus())).append(",")
                        .append((claim.getBankingInfo().getNumber())).append(",");
                if (claim.getDocuments() != null) {
                    for (String document : claim.getDocuments()) {
                        lineBuilder.append(document).append(";");
                    }
                }
                writer.write(lineBuilder.toString());
                writer.newLine();
            }
        }
    }

    public void saveInsuranceCard(Set<Customer> customers, String filePath) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            for (Customer customer : customers) {
                StringBuilder lineBuilder = new StringBuilder();
                lineBuilder.append(customer.getInsuranceCard().getCardNumber()).append(",").append(customer.getInsuranceCard().getCardHolder()).append(",")
                        .append((customer.getInsuranceCard().getPolicyOwner())).append(",")
                        .append(customer.getInsuranceCard().getExpirationDate().toString());

                writer.write(lineBuilder.toString());
                writer.newLine();
            }
        }
    }

    public void saveBankingInfo(Set<Claims> claims, String filePath) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            for (Claims claim : claims) {
                StringBuilder lineBuilder = new StringBuilder();
                lineBuilder.append(claim.getBankingInfo().getBankName()).append(",")
                        .append(claim.getBankingInfo().getOwnerName()).append(",")
                        .append((claim.getBankingInfo().getNumber()));

                writer.write(lineBuilder.toString());
                writer.newLine();
            }
        }
    }
}