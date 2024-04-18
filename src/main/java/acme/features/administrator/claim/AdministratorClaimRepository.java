
package acme.features.administrator.claim;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.group.Claim;

@Repository
public interface AdministratorClaimRepository extends AbstractRepository {

	@Query("SELECT c FROM Claim c")
	Collection<Claim> findAllClaims();

}
