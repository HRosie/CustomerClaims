package Code.Manager;

import Code.Claims.Claims;
import Code.Functions.ClaimController;

import java.util.Set;

public class ClaimProcessManagerImpl implements ClaimProcessManager {
    private ClaimController claimController;

    public ClaimProcessManagerImpl() {
        this.claimController = new ClaimController();
    }

    @Override
    public void addClaim(Claims claim) {
        claimController.addClaim(claim);
    }

    @Override
    public void updateClaim(Claims updatedClaim) {
        claimController.updateClaim(updatedClaim);
    }

    @Override
    public void deleteClaim(String claimId) {
        claimController.deleteClaim(claimId);
    }

    @Override
    public Claims getOneClaim(String claimId) {
        return claimController.getClaimById(claimId);
    }

    @Override
    public Set<Claims> getAllClaim() {
        return claimController.getAllClaims();
    }
}