package Code.Files;

import Code.Claims.*;
import Code.Customer.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Date;

public class LoadData {
    public Set<Customer> loadCustomers(String filePath) throws IOException {
        Set<Customer> customers = new HashSet<>();
        Map<String ,DependentCustomer> dependents = new HashMap();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String fullName = data[1];
                String customerType = data[2];
                String cardNumber = data[3];
                InsuranceID insuranceCard = null;

                if (customerType.equalsIgnoreCase("Dependent")) {
                    File file = new File("src/Code/Storage/Insurance.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    try (BufferedReader insuranceReader = new BufferedReader(new FileReader("src/Code/Storage/Insurance.txt"))) {
                        String insuranceLine;
                        while ((insuranceLine = insuranceReader.readLine()) != null) {
                            String[] insuranceData = insuranceLine.split(",");
                            if (cardNumber.equalsIgnoreCase(insuranceData[0])) {
                                insuranceCard = new InsuranceID(insuranceData[0], insuranceData[1], insuranceData[2], new Date(insuranceData[3]));
                                break;
                            }
                        }
                    }

                    Set<Claims> claims = new HashSet<>();
                    if (data.length >= 6 && data[5] != null && !data[5].isEmpty()) {
                        String[] claimsID = data[5].split(";");
                        file = new File("src/Code/Storage/Claims.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        try (BufferedReader claimReader = new BufferedReader(new FileReader("src/Code/Storage/Claims.txt"))) {
                            String claimLine;
                            while ((claimLine = claimReader.readLine()) != null) {
                                String[] claimData = claimLine.split(",");
                                if (Arrays.asList(claimsID).contains(claimData[0])) {
                                    Set<String> setDocuments = null;
                                    if (claimData.length >= 9 && claimData[8] != null && !claimData[8].isEmpty()) {
                                        String[] documents = claimData[8].split(";");
                                        setDocuments = new HashSet<>(Arrays.asList(documents));
                                    }
                                    BankingInfo receiverBankingInfo = null;
                                    file = new File("src/Code/Storage/BankInfo.txt");
                                    if (!file.exists()) {
                                        file.createNewFile();
                                    }
                                    try (BufferedReader bankingReader = new BufferedReader(new FileReader("src/Code/Storage/BankInfo.txt"))) {
                                        String bankingLine;
                                        while ((bankingLine = bankingReader.readLine()) != null) {
                                            String[] bankingData = bankingLine.split(",");
                                            if (claimData[7].equals(bankingData[2])) {
                                                receiverBankingInfo = new BankingInfo(bankingData[0], bankingData[1], bankingData[2]);
                                                break;
                                            }
                                        }
                                    }
                                    Claims claim = new Claims(claimData[0], new Date(claimData[1]), null, claimData[3], new Date(claimData[4]), setDocuments, Double.parseDouble(claimData[5]), Status.valueOf(claimData[6]), receiverBankingInfo);
                                    claims.add(claim);
                                }
                            }
                        }
                    }
                    DependentCustomer dependent = new DependentCustomer(id,fullName,insuranceCard,claims);
                    dependents.put(id,dependent);
                    customers.add(dependent);
                }

            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String fullName = data[1];
                String customerType = data[2];
                String cardNumber = data[3];
                InsuranceID insuranceCard = null;

                if (customerType.equalsIgnoreCase("PolicyHolder")) {
                    File file = new File("src/Code/Storage/Insurance.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    try (BufferedReader insuranceReader = new BufferedReader(new FileReader("src/Code/Storage/Insurance.txt"))) {
                        String insuranceLine;
                        while ((insuranceLine = insuranceReader.readLine()) != null) {
                            String[] insuranceData = insuranceLine.split(",");
                            if (cardNumber.equalsIgnoreCase(insuranceData[0])) {
                                insuranceCard = new InsuranceID(insuranceData[0], insuranceData[1], insuranceData[2], new Date(insuranceData[3]));
                                break;
                            }
                        }
                    }

                    Set<Claims> claims = new HashSet<>();
                    if (data.length >= 6 && data[5] != null && !data[5].isEmpty()) {
                        String[] claimsID = data[5].split(";");
                        file = new File("src/Code/Storage/Claims.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        try (BufferedReader claimReader = new BufferedReader(new FileReader("src/Code/Storage/Claims.txt"))) {
                            String claimLine;
                            while ((claimLine = claimReader.readLine()) != null) {
                                String[] claimData = claimLine.split(",");
                                if (Arrays.asList(claimsID).contains(claimData[0])) {
                                    Set<String> setDocuments = null;
                                    if (claimData.length >= 9 && claimData[8] != null && !claimData[8].isEmpty()) {
                                        String[] documents = claimData[8].split(";");
                                        setDocuments = new HashSet<>(Arrays.asList(documents));
                                    }
                                    BankingInfo receiverBankingInfo = null;
                                    file = new File("src/Code/Storage/BankInfo.txt");
                                    if (!file.exists()) {
                                        file.createNewFile();
                                    }
                                    try (BufferedReader bankingReader = new BufferedReader(new FileReader("src/Code/Storage/BankInfo.txt"))) {
                                        String bankingLine;
                                        while ((bankingLine = bankingReader.readLine()) != null) {
                                            String[] bankingData = bankingLine.split(",");
                                            if (claimData[7].equals(bankingData[2])) {
                                                receiverBankingInfo = new BankingInfo(bankingData[0], bankingData[1], bankingData[2]);
                                                break;
                                            }
                                        }
                                    }
                                    Claims claim = new Claims(claimData[0], new Date(claimData[1]), null, claimData[3], new Date(claimData[4]), setDocuments, Double.parseDouble(claimData[5]), Status.valueOf(claimData[6]), receiverBankingInfo);
                                    claims.add(claim);
                                }
                            }
                        }
                    }
                    Set<DependentCustomer> dependents1 = new HashSet<>();
                    if ((data.length >= 5 && data[4] != null && !data[4].isEmpty()))
                    {

                        String[] dependentsID = data[4].split(";");
                        for (int i = 0; i < dependentsID.length;i++ )
                        {
                            if (dependents.containsKey(dependentsID[i]))
                            {
                                dependents1.add(dependents.get(dependentsID[i]));
                            }
                        }
                    }
                    PolicyHolder policyHolder = new PolicyHolder(id,fullName,insuranceCard,claims,dependents1);
                    customers.add(policyHolder);
                }

            }
        }

        return customers;
    }


}
