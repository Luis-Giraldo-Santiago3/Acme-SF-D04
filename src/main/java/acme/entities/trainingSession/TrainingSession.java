
package acme.entities.trainingSession;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.data.AbstractEntity;

public class TrainingSession extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "TS-[A-Z]{1,3}-[0-9]{3}", message = "{validation.trainingModule.code}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	// Mirar restricciones de este
	private LocalDate			period;

	@NotBlank
	@Length(max = 75)
	private String				location;

	@NotBlank
	@Length(max = 75)
	private String				instructor;

	@NotNull
	private String				contactEmail;

	private String				link;

	private boolean				draftMode;

}
