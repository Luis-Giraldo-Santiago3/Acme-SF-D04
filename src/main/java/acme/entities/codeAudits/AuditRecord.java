
package acme.entities.codeAudits;

import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.client.data.AbstractEntity;
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

	@Column(unique = true)
	@Past
	@Min(1)
	private Period				period;

	@Column(nullable = false)
	private Mark				mark;

	private String				link;
}
