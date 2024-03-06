
package acme.entities.auditRecords;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
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
	@Temporal(TemporalType.TIME)
	private Date				auditPeriodStart;

	@Column(nullable = false)
	@Past
	@Temporal(TemporalType.TIME)
	private Date				auditPeriodEnd;

	@Column(nullable = false)
	private Mark				mark;

	@URL
	private String				link;

	// Relationships ----------------------------------------------------------

	@ManyToOne(optional = false)
	private CodeAudit			codeAudit;

}
