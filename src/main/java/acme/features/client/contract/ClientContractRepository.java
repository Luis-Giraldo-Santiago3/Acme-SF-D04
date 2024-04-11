
package acme.features.client.contract;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.student2.Contract;
import acme.entities.student2.ProgressLog;

@Repository
public interface ClientContractRepository extends AbstractRepository {

	@Query("select c from Contract c where c.client.id = :clientId")
	Collection<Contract> findManyContractsByClientId(int clientId);

	@Query("select c from Contract c where c.id = :id")
	Contract findOneContractById(int id);

	@Query("select pl from ProgressLog pl")
	Collection<ProgressLog> findAllProgressLog();

	@Query("select pl from ProgressLog pl where pl.contract.client.id = :clientId")
	Collection<ProgressLog> findManyProgressLogByClientId(int clientId);

}
