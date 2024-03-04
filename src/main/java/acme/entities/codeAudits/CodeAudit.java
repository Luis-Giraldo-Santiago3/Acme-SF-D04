
package acme.entities.codeAudits;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.client.data.AbstractEntity;
import acme.entities.auditRecords.Mark;
import acme.entities.project.Project;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CodeAudit extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------------

	@Pattern(regexp = "[A-Z]{1,3}-[0-9]{3}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	@Column(nullable = false)
	@Past
	@Temporal(TemporalType.DATE)
	private Date				executionDate;

	@Column(nullable = false)
	private Type				type;

	@NotBlank
	@Size(max = 101)
	private List<String>		correctiveActions;

	@Column(nullable = false)
	private Mark				mark;

	private String				link;

	// Relationships ----------------------------------------------------------

	@ManyToOne(optional = true)
	private Project				project;

}
