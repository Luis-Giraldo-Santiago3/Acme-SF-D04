
package acme.features.sponsor.sponsorship;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.student4.Sponsorship;

@Repository
public interface SponsorSponsorshipRepository extends AbstractRepository {

	@Query("SELECT s FROM Sponsorship s")
	Collection<Sponsorship> findAllSponsosrships();

	@Query("SELECT s FROM Sponsorship s WHERE s.id = :sponsorshipId")
	Sponsorship findOneSponsorshipById(int sponsorshipId);
}
