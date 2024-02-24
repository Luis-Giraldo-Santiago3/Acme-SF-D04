
package acme.entities.auditors;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Auditor extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotNull
	private Integer				staticCodeAudits;

	@NotNull
	private Integer				dynamicCodeAudits;

	@NotNull
	private Double				averageNumAuditRecords;

	@NotNull
	private Double				deviationNumAuditRecords;

	@NotNull
	private Integer				minNumAuditRecords;

	@NotNull
	private Integer				maxNumAuditRecords;

	@NotNull
	private Double				averageTimeAuditRecords;

	@NotNull
	private Double				deviationTimeAuditRecords;

	@NotNull
	private Integer				minTimeAuditRecords;

	@NotNull
	private Integer				maxTimeAuditRecords;

}
