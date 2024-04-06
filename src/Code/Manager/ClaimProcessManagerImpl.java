package Code.Manager;

import Code.Claims.Claims;
import java.util.HashSet;
import java.util.Set;

public class ClaimProcessManagerImpl implements ClaimProcessManager {
    private Set<Claims> claimsSet;

    public ClaimProcessManagerImpl() {
        this.claimsSet = new HashSet<>();
    }

    @Override
    public void addClaim(Claims claim) {
        claimsSet.add(claim);
        System.out.println("Claim added successfully.");
    }

    @Override
    public void updateClaim(Claims claim) {
        for (Claims c : claimsSet) {
            if (c.getClaimID().equals(claim.getClaimID())) {
                c.setClaimDate(claim.getClaimDate());
                c.setInsurancePeople(claim.getInsurancePeople());
                c.setInsuranceID(claim.getInsuranceID());
                c.setExamDate(claim.getExamDate());
                c.setClaimAmount(claim.getClaimAmount());
                c.setStatus(claim.getStatus());
                c.setBankInfo(claim.getBankInfo());
                System.out.println("Claim updated successfully.");
                return;
            }
        }
        System.out.println("Claim not found.");
    }

    @Override
    public void deleteClaim(String claimId) {
        for (Claims c : claimsSet) {
            if (c.getClaimID().equals(claimId)) {
                claimsSet.remove(c);
                System.out.println("Claim deleted successfully.");
                return;
            }
        }
        System.out.println("Claim not found.");
    }

    @Override
    public void getOneClaim(String claimId) {
        for (Claims c : claimsSet) {
            if (c.getClaimID().equals(claimId)) {
                System.out.println("Claim found:");
                System.out.println(c);
                return;
            }
        }
        System.out.println("Claim not found.");
    }

    @Override
    public Set<Claims> getAllClaim() {
        return claimsSet;
    }
}
