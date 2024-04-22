
package acme.features.administrator.banner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.group.Banner;
import acme.entities.student1.Project;

@Repository
public interface AdministratorBannerRepository extends AbstractRepository {

	@Query("SELECT b FROM Banner b")
	Collection<Banner> findAllBanners();

	@Query("SELECT p FROM Project p WHERE p.id = :projectId ")
	Project findOneProjectById(int projectId);
}
