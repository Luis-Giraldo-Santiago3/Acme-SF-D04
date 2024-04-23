
package acme.features.sponsor.sponsorship;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.student4.Sponsorship;
import acme.roles.Sponsor;

@Repository
public interface SponsorSponsorshipRepository extends AbstractRepository {

	@Query("SELECT s FROM Sponsorship s")
	Collection<Sponsorship> findAllSponsosrships();

	@Query("SELECT s FROM Sponsorship s WHERE s.id = :sponsorshipId")
	Sponsorship findOneSponsorshipById(int sponsorshipId);

	@Query("SELECT sp from Sponsor sp where sp.id = :sponsorId")
	Sponsor findSponsorById(int sponsorId);

	@Query("SELECT s from Sponsorship s where s.code = :code")
	Sponsorship findOneSponsorshipByCode(String code);
}
