
package acme.entities.trainingSession;

import java.time.Period;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.entities.trainingModule.TrainingModule;

public class TrainingSession extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "TS-[A-Z]{1,3}-[0-9]{3}", message = "{validation.trainingModule.code}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	// Mirar restricciones de este
	private Period				period;

	@NotBlank
	@Length(max = 75)
	private String				location;

	@NotBlank
	@Length(max = 75)
	private String				instructor;

	@NotNull
	private String				contactEmail;

	@URL
	private String				link;

	private boolean				draftMode;

	// Relationships

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private TrainingModule		trainingModule;

}
