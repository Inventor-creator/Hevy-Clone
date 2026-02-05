package HevyClone.Repos;

import HevyClone.ReturnObjects.AuthProviderReturnUser;
import HevyClone.Tables.AuthProviderIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface AuthProviderIdRepo extends JpaRepository<AuthProviderIds , Integer> {

    @Query(value = "SELECT * FROM auth_provider_ids a NATURAL JOIN users u WHERE provider_id = :gottenId;" , nativeQuery = true)
    Optional <AuthProviderReturnUser> getUserIfExists(@PathVariable("gottenId") String gottenId);


}
