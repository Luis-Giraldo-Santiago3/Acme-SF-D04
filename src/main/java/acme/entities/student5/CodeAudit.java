
package acme.entities.student5;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.roles.Auditor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CodeAudit extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------------

	@Pattern(regexp = "[A-Z]{1,3}-[0-9]{3}", message = "{validation.codeAudit.code}")
	@NotBlank
	@NotNull
	@Column(unique = true)
	private String				code;

	@NotNull
	@PastOrPresent
	@Temporal(TemporalType.TIMESTAMP)
	private Date				executionDate;

	@NotNull
	private Type				type;

	@NotBlank
	@Length(max = 100)
	private String				correctiveActions;

	@NotNull
	private Mark				mark;

	@URL
	@Length(max = 255)
	private String				link;

	private boolean				published;

	// Derived Attributes  ----------------------------------------------------------

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Auditor				auditor;

}
