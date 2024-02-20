
package acme.entities.claim;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Claim {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "C-[0-9]{4}", message = "{validation.claim.code}") // preguntar
	private String				code;

	@Past
	private LocalDate			instantiationMoment; // preguntas por el tipo de atributo

	@NotBlank
	@Length(max = 76)
	private String				heading;

	@NotBlank
	@Length(max = 101)
	private String				description;

	@NotBlank
	@Length(max = 101)
	private String				department;

	private String				emailAddress;

	private String				link;

}
