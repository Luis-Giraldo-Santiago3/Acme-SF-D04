
package acme.entities.sponsor;

import acme.client.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SponsorDashboard extends AbstractForm {

	private static final long	serialVersionUID	= 1L;

	Integer						totalInvoicesTaxLessEqual21;
	Integer						totalSponsorshipsWithLink;
	Double						averageSponsorships;
	Double						deviationSponsorships;
	Double						minimumSponsorships;
	Double						maximunSponsorships;
	Double						averageInvoices;
	Double						deviationInvoices;
	Double						minimumInvoices;
	Double						maximunInvoices;

}
