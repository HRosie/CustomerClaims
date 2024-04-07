package Code.Functions;

import Code.Claims.Claims;

import java.util.HashSet;
import java.util.Set;

public class ClaimController {
    private Set<Claims> claims;

    public ClaimController() {
        this.claims = new HashSet<>();
    }

    public void addClaim(Claims claim) {
        claims.add(claim);
    }

    public boolean updateClaim(Claims updatedClaim) {
        for (Claims claim : claims) {
            if (claim.getClaimID().equals(updatedClaim.getClaimID())) {
                // Update the claim
                claim.setClaimDate(updatedClaim.getClaimDate());
                claim.setInsurancePeople(updatedClaim.getInsurancePeople());
                // Update other claim attributes as needed
                return true; // Claim updated successfully
            }
        }
        return false; // Claim not found, update failed
    }

    public boolean deleteClaim(String id) {
        for (Claims claim : claims) {
            if (claim.getClaimID().equals(id)) {
                claims.remove(claim);
                return true; // Claim deleted successfully
            }
        }
        return false; // Claim not found, delete failed
    }

    public Claims getClaimById(String id) {
        for (Claims claim : claims) {
            if (claim.getClaimID().equals(id)) {
                return claim; // Return the claim if found
            }
        }
        return null; // Claim not found
    }

    public Set<Claims> getAllClaims() {
        return claims;
    }
}