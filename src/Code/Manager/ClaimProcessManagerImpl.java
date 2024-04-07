package Code.Manager;

import Code.Claims.Claims;
import Code.Files.LoadData;
import Code.Files.SaveData;

import java.util.HashSet;
import java.util.Set;

public class ClaimProcessManagerImpl implements ClaimProcessManager {

    private Set<Claims> claimsSet;

    public ClaimProcessManagerImpl() {
        claimsSet = LoadData.loadClaimsData("Claims.txt");
    }

    @Override
    public void addClaim(Claims claim) {
        if (validateClaimId(claim.getClaimID())) {
            claimsSet.add(claim);
            SaveData.saveClaimsData(claimsSet, "Claims.txt");
            System.out.println("Claim added successfully.");
        } else {
            System.out.println("Claim ID already exists. Please choose a different ID.");
        }
    }

    @Override
    public void updateClaim(Claims claim) {
        Claims existingClaim = getClaimById(claim.getClaimID());
        if (existingClaim != null) {
            claimsSet.remove(existingClaim);
            claimsSet.add(claim);
            SaveData.saveClaimsData(claimsSet, "Claims.txt");
            System.out.println("Claim updated successfully.");
        } else {
            System.out.println("Claim not found. Update failed.");
        }
    }

    @Override
    public void deleteClaim(String claimId) {
        Claims existingClaim = getClaimById(claimId);
        if (existingClaim != null) {
            claimsSet.remove(existingClaim);
            SaveData.saveClaimsData(claimsSet, "Claims.txt");
            System.out.println("Claim deleted successfully.");
        } else {
            System.out.println("Claim not found. Deletion failed.");
        }
    }

    @Override
    public void getOneClaim(String claimId) {
        Claims claim = getClaimById(claimId);
        if (claim != null) {
            claim.display();
        } else {
            System.out.println("Claim not found.");
        }
    }

    @Override
    public Set<Claims> getAllClaim() {
        return claimsSet;
    }

    // Helper method to validate if claim ID already exists
    private boolean validateClaimId(String claimId) {
        for (Claims claim : claimsSet) {
            if (claim.getClaimID().equals(claimId)) {
                return false; // Claim ID already exists
            }
        }
        return true; // Claim ID is unique
    }

    // Helper method to retrieve claim by ID
    private Claims getClaimById(String claimId) {
        for (Claims claim : claimsSet) {
            if (claim.getClaimID().equals(claimId)) {
                return claim;
            }
        }
        return null; // Claim not found
    }
}