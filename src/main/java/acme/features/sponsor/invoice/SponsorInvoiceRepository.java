
package acme.features.sponsor.invoice;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.student4.Invoice;

@Repository
public interface SponsorInvoiceRepository extends AbstractRepository {

	@Query("SELECT i FROM Invoice i")
	Collection<Invoice> findAllInvoices();

	@Query("SELECT i FROM Invoice i WHERE i.id = :invoiceId")
	Invoice findOneInvoiceById(int invoiceId);
}
