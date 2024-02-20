
package acme.entities.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "[A-Z]{3}-[0-9]{4}", message = "{validation.project.code}") // preguntar
	private String				code;

	@NotBlank
	@Length(max = 76)
	private String				title;

	@NotBlank
	@Length(max = 101)
	private String				summary; // esto es el abstract que piden pero abstract esta reservada

	private Boolean				cost;

	private String				link;

}
