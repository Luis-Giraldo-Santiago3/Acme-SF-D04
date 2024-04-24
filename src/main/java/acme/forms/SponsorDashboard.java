
package acme.forms;

import acme.client.data.AbstractForm;
import acme.client.data.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SponsorDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------
	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	Integer						totalInvoicesTaxLessEqual21;
	Integer						totalSponsorshipsWithLink;
	Double						averageSponsorships;
	Double						deviationSponsorships;
	Money						minimumSponsorships;
	Money						maximunSponsorships;
	Double						averageInvoices;
	Double						deviationInvoices;
	Money						minimumInvoices;
	Money						maximunInvoices;
}
