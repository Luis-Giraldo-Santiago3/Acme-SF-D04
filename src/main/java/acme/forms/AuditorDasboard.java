
package acme.forms;

import acme.client.data.AbstractForm;

public class AuditorDasboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int					staticCodeAudits;

	int					dynamicCodeAudits;

	Double				averageNumAuditRecords;

	Double				deviationNumAuditRecords;

	int					minNumAuditRecords;

	int					maxNumAuditRecords;

	Double				averageTimeAuditRecords;

	Double				deviationTimeAuditRecords;

	int					minTimeAuditRecords;

	int					maxTimeAuditRecords;

}
