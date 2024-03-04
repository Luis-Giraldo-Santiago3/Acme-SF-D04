
package acme.entities.auditRecords;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.client.data.AbstractEntity;
import acme.entities.auditors.Auditor;
import acme.entities.codeAudits.CodeAudit;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuditRecord extends AbstractEntity {

	// Serialisation identifier -----------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------
	@Pattern(regexp = "AU-[0-9]{4}-[09]{3}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	@Column(nullable = false)
	@Past
	private LocalDateTime		auditPeriodStart;

	@Column(nullable = false)
	@Past
	private LocalDateTime		auditPeriodEnd;

	@Column(nullable = false)
	private Mark				mark;

	private String				link;

	// Relationships ----------------------------------------------------------

	@ManyToOne(optional = false)
	private CodeAudit			codeAudit;

	@ManyToOne
	private Auditor				auditor;


	public AuditRecord(final String code, final LocalDateTime auditPeriodStart, final LocalDateTime auditPeriodEnd, final Mark mark, final String link) {
		this.code = code;
		this.auditPeriodStart = auditPeriodStart;
		this.auditPeriodEnd = auditPeriodEnd;
		this.mark = mark;
		this.link = link;

		// This is to ensure the period between the start and the end of the audit is at least 1 hour long
		if (auditPeriodStart.isAfter(auditPeriodEnd) || Duration.between(auditPeriodStart, auditPeriodEnd).toHours() < 1)
			throw new IllegalArgumentException("Audit period must be at least one hour long");
	}
}
