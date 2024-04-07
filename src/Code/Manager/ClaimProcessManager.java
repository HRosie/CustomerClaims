package Code.Manager;

import Code.Claims.Claims;
import java.util.Set;

public interface ClaimProcessManager {
    void addClaim(Claims claim);
    void updateClaim(Claims claim);
    void deleteClaim(String claimI);
    Claims getOneClaim(String claimId);
    Set<Claims> getAllClaim();
}
